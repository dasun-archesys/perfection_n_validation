package org.acme.deals;

import org.acme.deals.DealreviewsModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@org.springframework.stereotype.Component("dealreviews")
public class DealreviewsProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.deals.DealreviewsModel> {

    @org.springframework.beans.factory.annotation.Autowired()
    public DealreviewsProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        super(app, java.util.Arrays.asList(), correlations, factory);
        activate();
    }

    public DealreviewsProcess() {
    }

    @Override()
    public org.acme.deals.DealreviewsProcessInstance createInstance(org.acme.deals.DealreviewsModel value) {
        return new org.acme.deals.DealreviewsProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.acme.deals.DealreviewsProcessInstance createInstance(java.lang.String businessKey, org.acme.deals.DealreviewsModel value) {
        return new org.acme.deals.DealreviewsProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public org.acme.deals.DealreviewsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, org.acme.deals.DealreviewsModel value) {
        return new org.acme.deals.DealreviewsProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public org.acme.deals.DealreviewsModel createModel() {
        return new org.acme.deals.DealreviewsModel();
    }

    public org.acme.deals.DealreviewsProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.deals.DealreviewsModel) value);
    }

    public org.acme.deals.DealreviewsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.deals.DealreviewsModel) value);
    }

    public org.acme.deals.DealreviewsProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.DealreviewsProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.acme.deals.DealreviewsProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.DealreviewsProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("dealreviews", true);
        factory.variable("deal", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("deal", "deal", "ItemSubjectRef", "_dealItem"));
        factory.variable("review", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("review", "review", "ItemSubjectRef", "_reviewItem"));
        factory.variable("traveller", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.acme.deals.Traveller.class), java.util.Map.of("traveller", "traveller", "ItemSubjectRef", "_travellerItem"));
        factory.name("Deal Review");
        factory.packageName("org.acme.deals");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("jbpm.enable.multi.con", null);
        factory.metaData("jbpm.transactions.enable", "true");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        factory.imports("org.acme.travels.Traveller");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_AF59D427_38A9_4D28_B283_5916E2DABB2F = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AF59D427-38A9-4D28-B283-5916E2DABB2F"));
        endNode_AF59D427_38A9_4D28_B283_5916E2DABB2F.name("End Event 1");
        endNode_AF59D427_38A9_4D28_B283_5916E2DABB2F.terminate(false);
        endNode_AF59D427_38A9_4D28_B283_5916E2DABB2F.metaData("UniqueId", "_AF59D427-38A9-4D28-B283-5916E2DABB2F");
        endNode_AF59D427_38A9_4D28_B283_5916E2DABB2F.metaData("elementname", "End Event 1");
        endNode_AF59D427_38A9_4D28_B283_5916E2DABB2F.metaData("x", 757);
        endNode_AF59D427_38A9_4D28_B283_5916E2DABB2F.metaData("width", 56);
        endNode_AF59D427_38A9_4D28_B283_5916E2DABB2F.metaData("y", 315);
        endNode_AF59D427_38A9_4D28_B283_5916E2DABB2F.metaData("height", 56);
        endNode_AF59D427_38A9_4D28_B283_5916E2DABB2F.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93 = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3597E33A-1C00-41B3-924E-09EA47F79D93"));
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.name("Review the deal");
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.workParameter("ActorId", "john");
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.workParameter("NodeName", "Review the deal");
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.workParameter("Skippable", "true");
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.workParameter("TaskName", "review");
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.workParameter("UNIQUE_TASK_ID", "_3597E33A-1C00-41B3-924E-09EA47F79D93");
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("review", "review", "java.lang.String", null), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("deal", "deal", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_dealInputX", "deal", "java.lang.String", null), null, null));
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("traveller", "traveller", "org.acme.deals.Traveller", null)), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_travellerInputX", "traveller", "org.acme.deals.Traveller", null), null, null));
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("6afa7f6b-6800-473e-b93a-f8cee2404999", "EXPRESSION (true)", "java.lang.Object", "true"), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_reviewOutputX", "review", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("review", "review", "java.lang.String", null), null, null));
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.done();
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.metaData("UniqueId", "_3597E33A-1C00-41B3-924E-09EA47F79D93");
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.metaData("elementname", "Review the deal");
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.metaData("x", 523);
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.metaData("width", 154);
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.metaData("y", 292);
        humanTaskNode_3597E33A_1C00_41B3_924E_09EA47F79D93.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_7E3D27D0_6644_4E55_8E41_9F68BD0D1327 = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7E3D27D0-6644-4E55-8E41-9F68BD0D1327"));
        startNode_7E3D27D0_6644_4E55_8E41_9F68BD0D1327.name("Start Process");
        startNode_7E3D27D0_6644_4E55_8E41_9F68BD0D1327.interrupting(true);
        startNode_7E3D27D0_6644_4E55_8E41_9F68BD0D1327.metaData("UniqueId", "_7E3D27D0-6644-4E55-8E41-9F68BD0D1327");
        startNode_7E3D27D0_6644_4E55_8E41_9F68BD0D1327.metaData("elementname", "Start Process");
        startNode_7E3D27D0_6644_4E55_8E41_9F68BD0D1327.metaData("EventType", "none");
        startNode_7E3D27D0_6644_4E55_8E41_9F68BD0D1327.metaData("x", 387);
        startNode_7E3D27D0_6644_4E55_8E41_9F68BD0D1327.metaData("width", 56);
        startNode_7E3D27D0_6644_4E55_8E41_9F68BD0D1327.metaData("y", 315);
        startNode_7E3D27D0_6644_4E55_8E41_9F68BD0D1327.metaData("height", 56);
        startNode_7E3D27D0_6644_4E55_8E41_9F68BD0D1327.done();
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3597E33A-1C00-41B3-924E-09EA47F79D93"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_AF59D427-38A9-4D28-B283-5916E2DABB2F"), "_EECDD765-E29C-4D34-B390-25A729F40206");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7E3D27D0-6644-4E55-8E41-9F68BD0D1327"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3597E33A-1C00-41B3-924E-09EA47F79D93"), "_0EF9197C-8AD7-422D-BE5F-E01CF996E44F");
        factory.validate();
        return factory.getProcess();
    }
}
