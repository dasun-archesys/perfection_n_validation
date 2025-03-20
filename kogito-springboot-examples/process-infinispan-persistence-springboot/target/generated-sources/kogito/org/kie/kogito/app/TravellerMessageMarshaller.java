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

public class TravellerMessageMarshaller implements MessageMarshaller<org.acme.deals.Traveller> {

    public java.lang.Class<org.acme.deals.Traveller> getJavaClass() {
        return org.acme.deals.Traveller.class;
    }

    public String getTypeName() {
        return "org.kie.kogito.app.Traveller";
    }

    public org.acme.deals.Traveller readFrom(ProtoStreamReader reader) throws IOException {
        org.acme.deals.Traveller value = new org.acme.deals.Traveller();
        value.setAddress(reader.readObject("address", org.acme.deals.Address.class));
        value.setEmail(reader.readString("email"));
        value.setFirstName(reader.readString("firstName"));
        value.setLastName(reader.readString("lastName"));
        value.setNationality(reader.readString("nationality"));
        return value;
    }

    public void writeTo(ProtoStreamWriter writer, org.acme.deals.Traveller t) throws IOException {
        writer.writeObject("address", t.getAddress(), org.acme.deals.Address.class);
        writer.writeString("email", t.getEmail());
        writer.writeString("firstName", t.getFirstName());
        writer.writeString("lastName", t.getLastName());
        writer.writeString("nationality", t.getNationality());
    }
}
