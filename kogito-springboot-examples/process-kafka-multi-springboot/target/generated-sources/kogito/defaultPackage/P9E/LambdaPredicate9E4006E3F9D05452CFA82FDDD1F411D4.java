package defaultPackage.P9E;


import static defaultPackage.Rules6324881d1ea54fdb8686e664094bde94.*;
import org.acme.travel.Traveller;
import defaultPackage.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaPredicate9E4006E3F9D05452CFA82FDDD1F411D4 implements org.drools.model.functions.Predicate1<org.acme.travel.Traveller>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "CF940311C6CA01733E25A2F5ED5140C1";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public boolean test(org.acme.travel.Traveller _this) throws java.lang.Exception {
        return org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this.isProcessed(), false);
    }

    @Override()
    public org.drools.model.functions.PredicateInformation predicateInformation() {
        org.drools.model.functions.PredicateInformation info = new org.drools.model.functions.PredicateInformation("processed == false");
        info.addRuleNames("Don't process travellers from US", "/home/ec2-user/abc/kogito-springboot-examples/process-kafka-multi-springboot/src/main/resources/travellers.drl", "Process travellers", "/home/ec2-user/abc/kogito-springboot-examples/process-kafka-multi-springboot/src/main/resources/travellers.drl");
        return info;
    }
}
