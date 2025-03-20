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

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "Travelers", name = "Travelers", hidden = false)
public class TravelersModel implements org.kie.kogito.Model, MapInput, MapInputId, MapOutput, MappableToModel<TravelersModelOutput> {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "traveller")
    @jakarta.validation.Valid()
    private org.acme.travel.Traveller traveller;

    public org.acme.travel.Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(org.acme.travel.Traveller traveller) {
        this.traveller = traveller;
    }

    @Override()
    public TravelersModelOutput toModel() {
        TravelersModelOutput result = new TravelersModelOutput();
        result.setId(getId());
        result.setTraveller(getTraveller());
        return result;
    }
}
