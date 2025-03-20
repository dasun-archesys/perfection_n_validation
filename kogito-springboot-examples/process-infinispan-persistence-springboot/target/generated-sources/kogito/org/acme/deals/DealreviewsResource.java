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

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.jbpm.util.JsonSchemaUtil;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.ProcessService;
import org.kie.kogito.process.workitem.TaskModel;
import org.kie.kogito.auth.IdentityProviderFactory;
import org.kie.kogito.auth.SecurityPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/dealreviews")
@org.springframework.stereotype.Component()
public class DealreviewsResource {

    @org.springframework.beans.factory.annotation.Autowired()
    @org.springframework.beans.factory.annotation.Qualifier("dealreviews")
    Process<DealreviewsModel> process;

    @Autowired
    ProcessService processService;

    @Autowired
    IdentityProviderFactory identityProviderFactory;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "dealreviews", description = "")
    @org.springframework.transaction.annotation.Transactional()
    public ResponseEntity<DealreviewsModelOutput> createResource_dealreviews(@RequestHeader HttpHeaders httpHeaders, @RequestParam(value = "businessKey", required = false) String businessKey, @RequestBody(required = false) @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() DealreviewsModelInput resource, UriComponentsBuilder uriComponentsBuilder) {
        ProcessInstance<DealreviewsModel> pi = processService.createProcessInstance(process, businessKey, Optional.ofNullable(resource).orElse(new DealreviewsModelInput()).toModel(), httpHeaders, httpHeaders.getOrEmpty("X-KOGITO-StartFromNode").stream().findFirst().orElse(null), null, httpHeaders.getOrEmpty("X-KOGITO-ReferenceId").stream().findFirst().orElse(null), null);
        return ResponseEntity.created(uriComponentsBuilder.path("/dealreviews/{id}").buildAndExpand(pi.id()).toUri()).body(pi.checkError().variables().toModel());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "dealreviews", description = "")
    @org.springframework.transaction.annotation.Transactional()
    public List<DealreviewsModelOutput> getResources_dealreviews() {
        return processService.getProcessInstanceOutput(process);
    }

    @GetMapping(value = "/schema", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "dealreviews", description = "")
    @org.springframework.transaction.annotation.Transactional()
    public Map<String, Object> getResourceSchema_dealreviews() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "dealreviews", description = "")
    @org.springframework.transaction.annotation.Transactional()
    public DealreviewsModelOutput getResource_dealreviews(@PathVariable("id") String id) {
        return processService.findById(process, id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "dealreviews", description = "")
    @org.springframework.transaction.annotation.Transactional()
    public DealreviewsModelOutput deleteResource_dealreviews(@PathVariable("id") final String id) {
        return processService.delete(process, id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "dealreviews", description = "")
    @org.springframework.transaction.annotation.Transactional()
    public DealreviewsModelOutput updateModel_dealreviews(@PathVariable("id") String id, @RequestBody(required = false) @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() DealreviewsModelInput resource) {
        return processService.update(process, id, resource.toModel()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "dealreviews", description = "")
    @org.springframework.transaction.annotation.Transactional()
    public DealreviewsModelOutput updateModelPartial_dealreviews(@PathVariable("id") String id, @RequestBody(required = false) @jakarta.validation.Valid() @jakarta.validation.constraints.NotNull() DealreviewsModelInput resource) {
        return processService.updatePartial(process, id, resource.toModel()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/{id}/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "dealreviews", description = "")
    @org.springframework.transaction.annotation.Transactional()
    public List<TaskModel> getTasks_dealreviews(@PathVariable("id") String id, @RequestParam(value = "user", required = false) final String user, @RequestParam(value = "group", required = false) final List<String> groups) {
        return processService.getWorkItems(process, id, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups))).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).stream().map(org.acme.deals.Dealreviews_TaskModelFactory::from).collect(Collectors.toList());
    }

    @PostMapping(value = "/{id}/review/{taskId}/phases/{phase}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @org.springframework.transaction.annotation.Transactional()
    public DealreviewsModelOutput completeTask_review_0(@PathVariable("id") final String id, @PathVariable("taskId") final String taskId, @PathVariable("phase") final String phase, @RequestParam("user") final String user, @RequestParam("group") final List<String> groups, @RequestBody(required = false) final org.acme.deals.Dealreviews__3597E33A_1C00_41B3_924E_09EA47F79D93_TaskOutput model) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}/review/{taskId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @org.springframework.transaction.annotation.Transactional()
    public org.acme.deals.Dealreviews__3597E33A_1C00_41B3_924E_09EA47F79D93_TaskOutput saveTask_review_0(@PathVariable("id") final String id, @PathVariable("taskId") final String taskId, @RequestParam(value = "user", required = false) final String user, @RequestParam(value = "group", required = false) final List<String> groups, @RequestBody(required = false) final org.acme.deals.Dealreviews__3597E33A_1C00_41B3_924E_09EA47F79D93_TaskOutput model) {
        return processService.setWorkItemOutput(process, id, taskId, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model, org.acme.deals.Dealreviews__3597E33A_1C00_41B3_924E_09EA47F79D93_TaskOutput::fromMap).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/{id}/review/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @org.springframework.transaction.annotation.Transactional()
    public DealreviewsModelOutput taskTransition_review_0(@PathVariable("id") final String id, @PathVariable("taskId") final String taskId, @RequestParam(value = "phase", required = false, defaultValue = "complete") final String phase, @RequestParam(value = "user", required = false) final String user, @RequestParam(value = "group", required = false) final List<String> groups, @RequestBody(required = false) final org.acme.deals.Dealreviews__3597E33A_1C00_41B3_924E_09EA47F79D93_TaskOutput model) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), model).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/{id}/review/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @org.springframework.transaction.annotation.Transactional()
    public org.acme.deals.Dealreviews__3597E33A_1C00_41B3_924E_09EA47F79D93_TaskModel getTask_review_0(@PathVariable("id") String id, @PathVariable("taskId") String taskId, @RequestParam(value = "user", required = false) final String user, @RequestParam(value = "group", required = false) final List<String> groups) {
        return processService.getWorkItem(process, id, taskId, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), org.acme.deals.Dealreviews__3597E33A_1C00_41B3_924E_09EA47F79D93_TaskModel::from).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}/review/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @org.springframework.transaction.annotation.Transactional()
    public DealreviewsModelOutput abortTask_review_0(@PathVariable("id") final String id, @PathVariable("taskId") final String taskId, @RequestParam(value = "phase", required = false, defaultValue = "abort") final String phase, @RequestParam(value = "user", required = false) final String user, @RequestParam(value = "group", required = false) final List<String> groups) {
        return processService.transitionWorkItem(process, id, taskId, phase, SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)), null).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "review/schema", produces = MediaType.APPLICATION_JSON_VALUE)
    @org.springframework.transaction.annotation.Transactional()
    public Map<String, Object> getSchema_review_0() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "review");
    }

    @GetMapping(value = "/{id}/review/{taskId}/schema", produces = MediaType.APPLICATION_JSON_VALUE)
    @org.springframework.transaction.annotation.Transactional()
    public Map<String, Object> getSchemaAndPhases_review_0(@PathVariable("id") final String id, @PathVariable("taskId") final String taskId, @RequestParam(value = "user", required = false) final String user, @RequestParam(value = "group", required = false) final List<String> groups) {
        return processService.getWorkItemSchemaAndPhases(process, id, taskId, "review", SecurityPolicy.of(identityProviderFactory.getOrImpersonateIdentity(user, groups)));
    }
}
