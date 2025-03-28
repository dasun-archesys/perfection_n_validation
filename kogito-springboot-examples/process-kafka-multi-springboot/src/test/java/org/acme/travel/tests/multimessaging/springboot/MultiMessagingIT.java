/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.acme.travel.tests.multimessaging.springboot;

import java.io.UncheckedIOException;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.acme.travel.taxfile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.kie.kogito.test.springboot.kafka.KafkaTestClient;
import org.kie.kogito.testcontainers.springboot.KafkaSpringBootTestResource;
import org.kie.kogito.tests.KogitoKafkaMultiSpringbootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cloudevents.core.builder.CloudEventBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest(classes = KogitoKafkaMultiSpringbootApplication.class)
@ContextConfiguration(initializers = KafkaSpringBootTestResource.class)
public class MultiMessagingIT {

    public static final String TOPIC_PRODUCER = "input";
    public static final String TOPIC_PROCESSED_CONSUMER = "processed";
    public static final String TOPIC_CANCEL_CONSUMER = "skipped";

    private static Logger LOGGER = LoggerFactory.getLogger(MultiMessagingIT.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTestClient kafkaClient;

    @Test
    public void testProcess() throws InterruptedException {
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        //number of generated events to test
        final int count = 3;
        final CountDownLatch countDownLatch = new CountDownLatch(count);

        kafkaClient.consume(Arrays.asList(TOPIC_PROCESSED_CONSUMER, TOPIC_CANCEL_CONSUMER), s -> {
            LOGGER.info("Received from kafka: {}", s);
            try {
                JsonNode event = objectMapper.readValue(s, JsonNode.class);
                taxfile mytax = objectMapper.readValue(event.get("data").toString(), taxfile.class);
                assertEquals(mytax.getIncome() < 50000, mytax.isProcessed());
                assertTrue(mytax.getName().matches("Name[0-9]+"));
                countDownLatch.countDown();
            } catch (JsonProcessingException e) {
                LOGGER.error("Error parsing {}", s, e);
                fail(e);
            }
        });

        IntStream.range(0, count)
                .mapToObj(i -> new taxfile("Name" + i, i, i))
                .forEach(mytax -> kafkaClient.produce(generateCloudEvent(mytax), TOPIC_PRODUCER));

        countDownLatch.await(10, TimeUnit.SECONDS);
        assertEquals(0, countDownLatch.getCount());
    }

    private String generateCloudEvent(taxfile mytax) {
        assertFalse(mytax.isProcessed());
        try {
            return objectMapper.writeValueAsString(CloudEventBuilder.v1()
                    .withId(UUID.randomUUID().toString())
                    .withSource(URI.create(""))
                    //Start message event name in handle-travellers.bpmn
                    .withType("deductions")
                    .withTime(OffsetDateTime.now())
                    .withData(objectMapper.writeValueAsString(mytax).getBytes())
                    .build());
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(e);
        }
    }

    @AfterEach
    public void stop() {
        Optional.ofNullable(kafkaClient).ifPresent(KafkaTestClient::shutdown);
    }
}
