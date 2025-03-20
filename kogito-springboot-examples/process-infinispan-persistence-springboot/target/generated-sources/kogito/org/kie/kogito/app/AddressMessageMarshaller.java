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
package org.kie.kogito.app;

import java.io.IOException;
import org.infinispan.protostream.MessageMarshaller;

public class AddressMessageMarshaller implements MessageMarshaller<org.acme.deals.Address> {

    public java.lang.Class<org.acme.deals.Address> getJavaClass() {
        return org.acme.deals.Address.class;
    }

    public String getTypeName() {
        return "org.kie.kogito.app.Address";
    }

    public org.acme.deals.Address readFrom(ProtoStreamReader reader) throws IOException {
        org.acme.deals.Address value = new org.acme.deals.Address();
        value.setCity(reader.readString("city"));
        value.setCountry(reader.readString("country"));
        value.setStreet(reader.readString("street"));
        value.setZipCode(reader.readString("zipCode"));
        return value;
    }

    public void writeTo(ProtoStreamWriter writer, org.acme.deals.Address t) throws IOException {
        writer.writeString("city", t.getCity());
        writer.writeString("country", t.getCountry());
        writer.writeString("street", t.getStreet());
        writer.writeString("zipCode", t.getZipCode());
    }
}
