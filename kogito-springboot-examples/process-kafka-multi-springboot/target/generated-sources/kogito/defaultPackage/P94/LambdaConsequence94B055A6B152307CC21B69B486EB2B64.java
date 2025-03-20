package defaultPackage.P94;


import static defaultPackage.Rules30aa1c8810334f01bf31eb3a36b3cdf9.*;
import org.acme.travel.Traveller;
import defaultPackage.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaConsequence94B055A6B152307CC21B69B486EB2B64 implements org.drools.model.functions.Block1<org.acme.travel.Traveller>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "199ACB5B03E3E045864DBA0459A076B2";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public void execute(org.acme.travel.Traveller $traveller) throws java.lang.Exception {
        System.out.println("Hello traveller " + $traveller);
        $traveller.setProcessed(true);
    }
}
