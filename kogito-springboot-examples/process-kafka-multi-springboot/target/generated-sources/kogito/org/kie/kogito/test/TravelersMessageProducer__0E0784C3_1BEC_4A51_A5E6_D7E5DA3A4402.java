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
package org.kie.kogito.test;

import org.kie.kogito.event.EventEmitter;
import org.kie.kogito.event.impl.AbstractMessageProducer;

@org.springframework.stereotype.Component()
public class TravelersMessageProducer__0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402 extends AbstractMessageProducer<org.acme.travel.Traveller> {

    @org.springframework.beans.factory.annotation.Autowired()
    TravelersMessageProducer__0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402(EventEmitter emitter) {
        super(emitter, "processedtravellers");
    }
}
