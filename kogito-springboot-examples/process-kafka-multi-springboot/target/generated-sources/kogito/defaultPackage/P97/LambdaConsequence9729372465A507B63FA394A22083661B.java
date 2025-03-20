package defaultPackage.P97;


import static defaultPackage.Rules6324881d1ea54fdb8686e664094bde94.*;
import org.acme.travel.Traveller;
import defaultPackage.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaConsequence9729372465A507B63FA394A22083661B implements org.drools.model.functions.Block1<org.acme.travel.Traveller>, org.drools.model.functions.HashedExpression {

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
