package defaultPackage.PA5;


import static defaultPackage.Rules30aa1c8810334f01bf31eb3a36b3cdf9.*;
import org.acme.travel.Traveller;
import defaultPackage.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaPredicateA56A29D1824FB84DB3A63B724964357F implements org.drools.model.functions.Predicate1<org.acme.travel.Traveller>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "4A1368029CED39DFE5BB408185EAFDD5";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public boolean test(org.acme.travel.Traveller _this) throws java.lang.Exception {
        return org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this.getNationality(), "American");
    }

    @Override()
    public org.drools.model.functions.PredicateInformation predicateInformation() {
        org.drools.model.functions.PredicateInformation info = new org.drools.model.functions.PredicateInformation("nationality == \"American\"");
        info.addRuleNames("Don't process travellers from US", "/home/ec2-user/abc/kogito-springboot-examples/process-kafka-multi-springboot/src/main/resources/travellers.drl");
        return info;
    }
}
