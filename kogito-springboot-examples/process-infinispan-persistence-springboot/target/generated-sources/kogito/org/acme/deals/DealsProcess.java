package org.acme.deals;

import org.acme.deals.DealsModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@org.springframework.stereotype.Component("deals")
public class DealsProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.deals.DealsModel> {

    @org.springframework.beans.factory.annotation.Autowired()
    @org.springframework.beans.factory.annotation.Qualifier("dealreviews")
    org.kie.kogito.process.Process<DealreviewsModel> processdealreviews;

    @org.springframework.beans.factory.annotation.Autowired()
    public DealsProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        super(app, java.util.Arrays.asList(), correlations, factory);
        activate();
    }

    public DealsProcess() {
    }

    @Override()
    public org.acme.deals.DealsProcessInstance createInstance(org.acme.deals.DealsModel value) {
        return new org.acme.deals.DealsProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.acme.deals.DealsProcessInstance createInstance(java.lang.String businessKey, org.acme.deals.DealsModel value) {
        return new org.acme.deals.DealsProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public org.acme.deals.DealsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, org.acme.deals.DealsModel value) {
        return new org.acme.deals.DealsProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public org.acme.deals.DealsModel createModel() {
        return new org.acme.deals.DealsModel();
    }

    public org.acme.deals.DealsProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.deals.DealsModel) value);
    }

    public org.acme.deals.DealsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.deals.DealsModel) value);
    }

    public org.acme.deals.DealsProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.DealsProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.acme.deals.DealsProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.DealsProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("deals", true);
        factory.variable("name", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("name", "name", "ItemSubjectRef", "_nameItem"));
        factory.variable("review", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("review", "review", "ItemSubjectRef", "_reviewItem"));
        factory.variable("traveller", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.acme.deals.Traveller.class), java.util.Map.of("traveller", "traveller", "ItemSubjectRef", "_travellerItem"));
        factory.name("SubmitDeal");
        factory.packageName("org.acme.deals");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("jbpm.enable.multi.con", null);
        factory.metaData("jbpm.transactions.enable", "true");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        factory.imports("org.acme.travels.Traveller");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_4583DB41_9B89_4729_AC8A_A0666534E616 = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4583DB41-9B89-4729-AC8A-A0666534E616"));
        endNode_4583DB41_9B89_4729_AC8A_A0666534E616.name("End Event 1");
        endNode_4583DB41_9B89_4729_AC8A_A0666534E616.terminate(false);
        endNode_4583DB41_9B89_4729_AC8A_A0666534E616.metaData("UniqueId", "_4583DB41-9B89-4729-AC8A-A0666534E616");
        endNode_4583DB41_9B89_4729_AC8A_A0666534E616.metaData("elementname", "End Event 1");
        endNode_4583DB41_9B89_4729_AC8A_A0666534E616.metaData("x", 939);
        endNode_4583DB41_9B89_4729_AC8A_A0666534E616.metaData("width", 56);
        endNode_4583DB41_9B89_4729_AC8A_A0666534E616.metaData("y", 154);
        endNode_4583DB41_9B89_4729_AC8A_A0666534E616.metaData("height", 56);
        endNode_4583DB41_9B89_4729_AC8A_A0666534E616.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_0BAE98AF_9B65_444E_9B84_E48A3B593DBE = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0BAE98AF-9B65-444E-9B84-E48A3B593DBE"));
        actionNode_0BAE98AF_9B65_444E_9B84_E48A3B593DBE.name("Print review of the deal");
        actionNode_0BAE98AF_9B65_444E_9B84_E48A3B593DBE.metaData("UniqueId", "_0BAE98AF-9B65-444E-9B84-E48A3B593DBE");
        actionNode_0BAE98AF_9B65_444E_9B84_E48A3B593DBE.metaData("elementname", "Print review of the deal");
        actionNode_0BAE98AF_9B65_444E_9B84_E48A3B593DBE.metaData("NodeType", "ScriptTask");
        actionNode_0BAE98AF_9B65_444E_9B84_E48A3B593DBE.metaData("x", 700);
        actionNode_0BAE98AF_9B65_444E_9B84_E48A3B593DBE.metaData("width", 154);
        actionNode_0BAE98AF_9B65_444E_9B84_E48A3B593DBE.metaData("y", 131);
        actionNode_0BAE98AF_9B65_444E_9B84_E48A3B593DBE.metaData("height", 102);
        actionNode_0BAE98AF_9B65_444E_9B84_E48A3B593DBE.action(kcontext -> {
            java.lang.String review = (java.lang.String) kcontext.getVariable("review");
            org.acme.deals.Traveller traveller = (org.acme.deals.Traveller) kcontext.getVariable("traveller");
            System.out.println("Review of the deal " + review + " for traveller " + traveller.getLastName());
        });
        actionNode_0BAE98AF_9B65_444E_9B84_E48A3B593DBE.done();
        org.jbpm.ruleflow.core.factory.SubProcessNodeFactory<?> subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6 = factory.subProcessNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C3082C6F-963E-40A2-B31B-1E8F336AA4C6"));
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.name("Call a deal");
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.processId("dealreviews");
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.processName("");
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.waitForCompletion(true);
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.independent(false);
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.subProcessNode(new org.jbpm.workflow.core.node.SubProcessFactory<DealreviewsModel>() {

            public DealreviewsModel bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                org.acme.deals.DealreviewsModel model = new org.acme.deals.DealreviewsModel();
                java.util.Map<java.lang.String, java.lang.Object> inputs = org.jbpm.workflow.core.impl.NodeIoHelper.processInputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
                model.update(inputs);
                return model;
            }

            public org.kie.kogito.process.ProcessInstance<DealreviewsModel> createInstance(DealreviewsModel model) {
                return (org.kie.kogito.process.ProcessInstance<DealreviewsModel>) app.get(org.kie.kogito.process.Processes.class).processById("dealreviews").createInstance(model);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, DealreviewsModel model) {
                java.util.Map<java.lang.String, java.lang.Object> outputs = new java.util.HashMap<java.lang.String, java.lang.Object>();
                outputs.put("review", model.getReview());
                org.jbpm.workflow.core.impl.NodeIoHelper.processOutputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return outputs.get(name);
                }, (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
            }
        });
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("name", "name", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_C3082C6F-963E-40A2-B31B-1E8F336AA4C6_dealInputX", "deal", "java.lang.String", null), null, null));
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("traveller", "traveller", "org.acme.deals.Traveller", null)), new org.jbpm.workflow.core.impl.DataDefinition("_C3082C6F-963E-40A2-B31B-1E8F336AA4C6_travellerInputX", "traveller", "org.acme.deals.Traveller", null), null, null));
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_C3082C6F-963E-40A2-B31B-1E8F336AA4C6_reviewOutputX", "review", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("review", "review", "java.lang.String", null), null, null));
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.metaData("UniqueId", "_C3082C6F-963E-40A2-B31B-1E8F336AA4C6");
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.metaData("elementname", "Call a deal");
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.metaData("x", 471);
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.metaData("width", 154);
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.metaData("y", 131);
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.metaData("height", 102);
        subProcessNode_C3082C6F_963E_40A2_B31B_1E8F336AA4C6.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_CBED5120_F3EC_40A0_9A1F_072F37FA1204 = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CBED5120-F3EC-40A0-9A1F-072F37FA1204"));
        startNode_CBED5120_F3EC_40A0_9A1F_072F37FA1204.name("Start Proces");
        startNode_CBED5120_F3EC_40A0_9A1F_072F37FA1204.interrupting(true);
        startNode_CBED5120_F3EC_40A0_9A1F_072F37FA1204.metaData("UniqueId", "_CBED5120-F3EC-40A0-9A1F-072F37FA1204");
        startNode_CBED5120_F3EC_40A0_9A1F_072F37FA1204.metaData("elementname", "Start Proces");
        startNode_CBED5120_F3EC_40A0_9A1F_072F37FA1204.metaData("EventType", "none");
        startNode_CBED5120_F3EC_40A0_9A1F_072F37FA1204.metaData("x", 335);
        startNode_CBED5120_F3EC_40A0_9A1F_072F37FA1204.metaData("width", 56);
        startNode_CBED5120_F3EC_40A0_9A1F_072F37FA1204.metaData("y", 154);
        startNode_CBED5120_F3EC_40A0_9A1F_072F37FA1204.metaData("height", 56);
        startNode_CBED5120_F3EC_40A0_9A1F_072F37FA1204.done();
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0BAE98AF-9B65-444E-9B84-E48A3B593DBE"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4583DB41-9B89-4729-AC8A-A0666534E616"), "_BCF778A5-0959-49DA-B8FF-DB61025A7DD0");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C3082C6F-963E-40A2-B31B-1E8F336AA4C6"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0BAE98AF-9B65-444E-9B84-E48A3B593DBE"), "_A186F5CE-4300-4506-A89D-50DEDC8F24CF");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_CBED5120-F3EC-40A0-9A1F-072F37FA1204"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_C3082C6F-963E-40A2-B31B-1E8F336AA4C6"), "_E3E55042-CEC7-4574-8315-068794ACBD69");
        factory.validate();
        return factory.getProcess();
    }

    protected void registerListeners() {
        services.getSignalManager().addEventListener("dealreviews", completionEventListener);
    }
}
