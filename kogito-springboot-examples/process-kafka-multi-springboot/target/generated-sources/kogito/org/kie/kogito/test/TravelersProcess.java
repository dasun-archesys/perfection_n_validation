package org.kie.kogito.test;

import org.kie.kogito.test.TravelersModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;

@org.springframework.stereotype.Component("Travelers")
public class TravelersProcess extends org.kie.kogito.process.impl.AbstractProcess<org.kie.kogito.test.TravelersModel> {

    @org.springframework.beans.factory.annotation.Autowired()
    org.kie.kogito.test.TravelersMessageProducer__67233131_DCD2_4EFC_9B7A_0754E12375AC producer__67233131_DCD2_4EFC_9B7A_0754E12375AC;

    @org.springframework.beans.factory.annotation.Autowired()
    org.kie.kogito.test.TravelersMessageProducer__0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402 producer__0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402;

    @org.springframework.beans.factory.annotation.Autowired()
    public TravelersProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations) {
        super(app, java.util.Arrays.asList(), correlations);
        activate();
    }

    public TravelersProcess() {
    }

    @Override()
    public org.kie.kogito.test.TravelersProcessInstance createInstance(org.kie.kogito.test.TravelersModel value) {
        return new org.kie.kogito.test.TravelersProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.kie.kogito.test.TravelersProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.test.TravelersModel value) {
        return new org.kie.kogito.test.TravelersProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public org.kie.kogito.test.TravelersProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, org.kie.kogito.test.TravelersModel value) {
        return new org.kie.kogito.test.TravelersProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public org.kie.kogito.test.TravelersModel createModel() {
        return new org.kie.kogito.test.TravelersModel();
    }

    public org.kie.kogito.test.TravelersProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.kie.kogito.test.TravelersModel) value);
    }

    public org.kie.kogito.test.TravelersProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.kie.kogito.test.TravelersModel) value);
    }

    public org.kie.kogito.test.TravelersProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kie.kogito.test.TravelersProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.kie.kogito.test.TravelersProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kie.kogito.test.TravelersProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("Travelers", true);
        factory.variable("traveller", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.acme.travel.Traveller.class), java.util.Map.of("traveller", "traveller", "ItemSubjectRef", "_travellerItem"));
        factory.name("Process travelers");
        factory.packageName("org.kie.kogito.test");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("jbpm.enable.multi.con", null);
        factory.metaData("jbpm.transactions.enable", "true");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        factory.newCorrelationMessage("_h2dOUJFrEDmQPdE0CWoRjQ", "processedtravellers", "org.acme.travel.Traveller");
        factory.newCorrelationMessage("_h2d1YZFrEDmQPdE0CWoRjQ", "no travel", "org.acme.travel.Traveller");
        factory.newCorrelationMessage("_h2d1YJFrEDmQPdE0CWoRjQ", "travellers", "org.acme.travel.Traveller");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_67233131-DCD2-4EFC-9B7A-0754E12375AC"));
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.name("no travel");
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.terminate(false);
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.action(new org.jbpm.process.instance.impl.actions.ProduceEventAction<org.acme.travel.Traveller>("no travel", "event", () -> producer__67233131_DCD2_4EFC_9B7A_0754E12375AC));
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("traveller", "traveller", "org.acme.travel.Traveller", null)), new org.jbpm.workflow.core.impl.DataDefinition("_67233131-DCD2-4EFC-9B7A-0754E12375AC_eventInputX", "event", "org.acme.travel.Traveller", null), null, null));
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("UniqueId", "_67233131-DCD2-4EFC-9B7A-0754E12375AC");
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("TriggerType", "ProduceMessage");
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("Variable", "traveller");
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("EventType", "message");
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("TriggerRef", "no travel");
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("elementname", "no travel");
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("MappingVariableInput", "event");
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("x", 1244);
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("width", 56);
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("y", 384);
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("MappingVariable", "traveller");
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("MessageType", "org.acme.travel.Traveller");
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.metaData("height", 56);
        endNode_67233131_DCD2_4EFC_9B7A_0754E12375AC.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_0C615323_1520_40BF_8A41_46C2BBC6819C = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0C615323-1520-40BF-8A41-46C2BBC6819C"));
        actionNode_0C615323_1520_40BF_8A41_46C2BBC6819C.name("Skip Traveler");
        actionNode_0C615323_1520_40BF_8A41_46C2BBC6819C.metaData("UniqueId", "_0C615323-1520-40BF-8A41-46C2BBC6819C");
        actionNode_0C615323_1520_40BF_8A41_46C2BBC6819C.metaData("elementname", "Skip Traveler");
        actionNode_0C615323_1520_40BF_8A41_46C2BBC6819C.metaData("NodeType", "ScriptTask");
        actionNode_0C615323_1520_40BF_8A41_46C2BBC6819C.metaData("x", 1018);
        actionNode_0C615323_1520_40BF_8A41_46C2BBC6819C.metaData("width", 154);
        actionNode_0C615323_1520_40BF_8A41_46C2BBC6819C.metaData("y", 361);
        actionNode_0C615323_1520_40BF_8A41_46C2BBC6819C.metaData("height", 102);
        actionNode_0C615323_1520_40BF_8A41_46C2BBC6819C.action(kcontext -> {
            org.acme.travel.Traveller traveller = (org.acme.travel.Traveller) kcontext.getVariable("traveller");
            System.out.println("Skipping traveller " + traveller);
        });
        actionNode_0C615323_1520_40BF_8A41_46C2BBC6819C.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_B7417363_C542_4A4A_A314_2AF370DE2515 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B7417363-C542-4A4A-A314-2AF370DE2515"));
        actionNode_B7417363_C542_4A4A_A314_2AF370DE2515.name("Log Traveler");
        actionNode_B7417363_C542_4A4A_A314_2AF370DE2515.metaData("UniqueId", "_B7417363-C542-4A4A-A314-2AF370DE2515");
        actionNode_B7417363_C542_4A4A_A314_2AF370DE2515.metaData("elementname", "Log Traveler");
        actionNode_B7417363_C542_4A4A_A314_2AF370DE2515.metaData("NodeType", "ScriptTask");
        actionNode_B7417363_C542_4A4A_A314_2AF370DE2515.metaData("x", 1018);
        actionNode_B7417363_C542_4A4A_A314_2AF370DE2515.metaData("width", 154);
        actionNode_B7417363_C542_4A4A_A314_2AF370DE2515.metaData("y", 170);
        actionNode_B7417363_C542_4A4A_A314_2AF370DE2515.metaData("height", 102);
        actionNode_B7417363_C542_4A4A_A314_2AF370DE2515.action(kcontext -> {
            org.acme.travel.Traveller traveller = (org.acme.travel.Traveller) kcontext.getVariable("traveller");
            System.out.println("Processing traveller " + traveller);
        });
        actionNode_B7417363_C542_4A4A_A314_2AF370DE2515.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8BEA9396-93DE-4D44-8CE2-4A146464264E"));
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.name("travelers");
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.interrupting(true);
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("TriggerMapping", "traveller");
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("UniqueId", "_8BEA9396-93DE-4D44-8CE2-4A146464264E");
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("TriggerType", "ConsumeMessage");
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("EventType", "message");
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("MessageRef", "_h2d1YJFrEDmQPdE0CWoRjQ");
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("TriggerRef", "travellers");
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("elementname", "travelers");
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("x", 520);
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("width", 56);
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("y", 193);
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("MappingVariable", "traveller");
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("TriggerMappingInput", "event");
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("MessageType", "org.acme.travel.Traveller");
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.metaData("height", 56);
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_8BEA9396-93DE-4D44-8CE2-4A146464264E_eventOutputX", "event", "org.acme.travel.Traveller", null)), new org.jbpm.workflow.core.impl.DataDefinition("traveller", "traveller", "org.acme.travel.Traveller", null), null, null));
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.trigger("travellers", java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_8BEA9396-93DE-4D44-8CE2-4A146464264E_eventOutputX", "event", "org.acme.travel.Traveller", null)), new org.jbpm.workflow.core.impl.DataDefinition("traveller", "traveller", "org.acme.travel.Traveller", null), null, null)));
        startNode_8BEA9396_93DE_4D44_8CE2_4A146464264E.done();
        org.jbpm.ruleflow.core.factory.RuleSetNodeFactory<?> ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8 = factory.ruleSetNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_60FA6326-76DC-4DB2-AB06-DB8AC8EE8DC8"));
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.name("Process Traveler");
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.ruleFlowGroup("travellers", () -> {
            org.kie.kogito.rules.RuleConfig ruleConfig = app.config().get(org.kie.kogito.rules.RuleConfig.class);
            org.kie.api.runtime.KieSession ksession = org.drools.project.model.ProjectRuntime.INSTANCE.newKieSession("defaultStatelessKieSession");
            ruleConfig.ruleEventListeners().agendaListeners().forEach(ksession::addEventListener);
            ruleConfig.ruleEventListeners().ruleRuntimeListeners().forEach(ksession::addEventListener);
            return ksession;
        });
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("traveller", "traveller", "org.acme.travel.Traveller", null)), new org.jbpm.workflow.core.impl.DataDefinition("_60FA6326-76DC-4DB2-AB06-DB8AC8EE8DC8_travellerInputX", "traveller", "org.acme.travel.Traveller", null), null, null));
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_60FA6326-76DC-4DB2-AB06-DB8AC8EE8DC8_travellerOutputX", "traveller", "org.acme.travel.Traveller", null)), new org.jbpm.workflow.core.impl.DataDefinition("traveller", "traveller", "org.acme.travel.Traveller", null), null, null));
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.metaData("UniqueId", "_60FA6326-76DC-4DB2-AB06-DB8AC8EE8DC8");
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.metaData("elementname", "Process Traveler");
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.metaData("x", 648);
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.metaData("width", 154);
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.metaData("y", 170);
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.metaData("customAsync", "false");
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.metaData("height", 102);
        ruleSetNode_60FA6326_76DC_4DB2_AB06_DB8AC8EE8DC8.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9 = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_58FF9DA5-06C6-4D71-91CD-6EAE4E999CF9"));
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.name("Processed Traveler?");
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.type(2);
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.metaData("UniqueId", "_58FF9DA5-06C6-4D71-91CD-6EAE4E999CF9");
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.metaData("elementname", "Processed Traveler?");
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.metaData("x", 882);
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.metaData("width", 56);
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.metaData("y", 193);
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.metaData("Default", null);
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.metaData("height", 56);
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B7417363-C542-4A4A-A314-2AF370DE2515"), "_C5756B00-2541-4948-A7F5-4494A10E3A31", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.travel.Traveller traveller = (org.acme.travel.Traveller) kcontext.getVariable("traveller");
            return traveller.isProcessed();
        }, 0, false);
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0C615323-1520-40BF-8A41-46C2BBC6819C"), "_EDFD7D46-79EC-4C49-B6D8-5873E9301AC7", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.travel.Traveller traveller = (org.acme.travel.Traveller) kcontext.getVariable("traveller");
            return !traveller.isProcessed();
        }, 0, false);
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.done();
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B7417363-C542-4A4A-A314-2AF370DE2515"), "_C5756B00-2541-4948-A7F5-4494A10E3A31", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.travel.Traveller traveller = (org.acme.travel.Traveller) kcontext.getVariable("traveller");
            return traveller.isProcessed();
        }, 0, false);
        splitNode_58FF9DA5_06C6_4D71_91CD_6EAE4E999CF9.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0C615323-1520-40BF-8A41-46C2BBC6819C"), "_EDFD7D46-79EC-4C49-B6D8-5873E9301AC7", "DROOLS_DEFAULT", "java", kcontext -> {
            org.acme.travel.Traveller traveller = (org.acme.travel.Traveller) kcontext.getVariable("traveller");
            return !traveller.isProcessed();
        }, 0, false);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402 = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0E0784C3-1BEC-4A51-A5E6-D7E5DA3A4402"));
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.name("processedtraveler");
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.terminate(false);
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.action(new org.jbpm.process.instance.impl.actions.ProduceEventAction<org.acme.travel.Traveller>("processedtravellers", "event", () -> producer__0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402));
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("traveller", "traveller", "org.acme.travel.Traveller", null)), new org.jbpm.workflow.core.impl.DataDefinition("_0E0784C3-1BEC-4A51-A5E6-D7E5DA3A4402_eventInputX", "event", "org.acme.travel.Traveller", null), null, null));
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("UniqueId", "_0E0784C3-1BEC-4A51-A5E6-D7E5DA3A4402");
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("TriggerType", "ProduceMessage");
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("Variable", "traveller");
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("EventType", "message");
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("TriggerRef", "processedtravellers");
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("elementname", "processedtraveler");
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("MappingVariableInput", "event");
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("x", 1252);
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("width", 56);
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("y", 193);
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("MappingVariable", "traveller");
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("MessageType", "org.acme.travel.Traveller");
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.metaData("height", 56);
        endNode_0E0784C3_1BEC_4A51_A5E6_D7E5DA3A4402.done();
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0C615323-1520-40BF-8A41-46C2BBC6819C"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_67233131-DCD2-4EFC-9B7A-0754E12375AC"), "_148A7959-371E-4EC5-9676-1A98C95BA7E8");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_58FF9DA5-06C6-4D71-91CD-6EAE4E999CF9"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0C615323-1520-40BF-8A41-46C2BBC6819C"), "_EDFD7D46-79EC-4C49-B6D8-5873E9301AC7");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_58FF9DA5-06C6-4D71-91CD-6EAE4E999CF9"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B7417363-C542-4A4A-A314-2AF370DE2515"), "_C5756B00-2541-4948-A7F5-4494A10E3A31");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8BEA9396-93DE-4D44-8CE2-4A146464264E"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_60FA6326-76DC-4DB2-AB06-DB8AC8EE8DC8"), "_D15CD483-D31D-42F8-A93A-AAAF44292D84");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_60FA6326-76DC-4DB2-AB06-DB8AC8EE8DC8"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_58FF9DA5-06C6-4D71-91CD-6EAE4E999CF9"), "_96F8E118-C58C-4369-89DC-2C881614FF73");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B7417363-C542-4A4A-A314-2AF370DE2515"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0E0784C3-1BEC-4A51-A5E6-D7E5DA3A4402"), "_6ED9B3DA-9FD9-49F3-A70E-A6AB6712A628");
        factory.validate();
        return factory.getProcess();
    }
}
