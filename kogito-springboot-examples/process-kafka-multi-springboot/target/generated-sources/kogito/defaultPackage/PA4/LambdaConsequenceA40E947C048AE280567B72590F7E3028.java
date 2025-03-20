package defaultPackage.PA4;


import static defaultPackage.Rules30aa1c8810334f01bf31eb3a36b3cdf9.*;
import org.acme.travel.Traveller;
import defaultPackage.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaConsequenceA40E947C048AE280567B72590F7E3028 implements org.drools.model.functions.Block1<org.acme.travel.Traveller>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "A955CF61C703C31EA0FD512849D26DD0";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public void execute(org.acme.travel.Traveller $traveller) throws java.lang.Exception {
        System.out.println("This system can't deal with " + $traveller.getNationality());
        $traveller.setProcessed(false);
    }
}
