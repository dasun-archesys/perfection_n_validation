package defaultPackage.P95;


import static defaultPackage.Rules30aa1c8810334f01bf31eb3a36b3cdf9.*;
import org.acme.travel.Traveller;
import defaultPackage.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaPredicate95BE56602FA3E9952521BC27CDBE6F42 implements org.drools.model.functions.Predicate1<org.acme.travel.Traveller>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "7930A61A273066A0692D58CF77904D14";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public boolean test(org.acme.travel.Traveller _this) throws java.lang.Exception {
        return !org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this.getNationality(), "American");
    }

    @Override()
    public org.drools.model.functions.PredicateInformation predicateInformation() {
        org.drools.model.functions.PredicateInformation info = new org.drools.model.functions.PredicateInformation("nationality != \"American\"");
        info.addRuleNames("Process travellers", "/home/ec2-user/abc/kogito-springboot-examples/process-kafka-multi-springboot/src/main/resources/travellers.drl");
        return info;
    }
}
