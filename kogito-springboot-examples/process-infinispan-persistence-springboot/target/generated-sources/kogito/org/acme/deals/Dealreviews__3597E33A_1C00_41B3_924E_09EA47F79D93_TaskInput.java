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
package org.acme.deals;

import java.util.Map;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "review", processName = "dealreviews")
public class Dealreviews__3597E33A_1C00_41B3_924E_09EA47F79D93_TaskInput {

    public static Dealreviews__3597E33A_1C00_41B3_924E_09EA47F79D93_TaskInput fromMap(Map<String, Object> params) {
        Dealreviews__3597E33A_1C00_41B3_924E_09EA47F79D93_TaskInput item = new Dealreviews__3597E33A_1C00_41B3_924E_09EA47F79D93_TaskInput();
        item.deal = (java.lang.String) params.get("deal");
        item.traveller = (org.acme.deals.Traveller) params.get("traveller");
        return item;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String deal;

    public java.lang.String getDeal() {
        return deal;
    }

    public void setDeal(java.lang.String deal) {
        this.deal = deal;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private org.acme.deals.Traveller traveller;

    public org.acme.deals.Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(org.acme.deals.Traveller traveller) {
        this.traveller = traveller;
    }
}
//Task input for user task 'Review the deal' in process 'dealreviews'
