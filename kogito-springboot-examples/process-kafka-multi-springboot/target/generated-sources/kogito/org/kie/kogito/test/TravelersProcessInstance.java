package org.kie.kogito.test;

import org.kie.kogito.test.TravelersModel;

public class TravelersProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<TravelersModel> {

    public TravelersProcessInstance(org.kie.kogito.test.TravelersProcess process, TravelersModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public TravelersProcessInstance(org.kie.kogito.test.TravelersProcess process, TravelersModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public TravelersProcessInstance(org.kie.kogito.test.TravelersProcess process, TravelersModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public TravelersProcessInstance(org.kie.kogito.test.TravelersProcess process, TravelersModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public TravelersProcessInstance(org.kie.kogito.test.TravelersProcess process, TravelersModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(TravelersModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(TravelersModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
