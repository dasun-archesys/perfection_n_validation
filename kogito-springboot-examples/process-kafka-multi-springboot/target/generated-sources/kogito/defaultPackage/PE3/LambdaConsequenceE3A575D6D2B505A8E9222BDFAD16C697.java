package defaultPackage.PE3;


import static defaultPackage.Rules6324881d1ea54fdb8686e664094bde94.*;
import org.acme.travel.Traveller;
import defaultPackage.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaConsequenceE3A575D6D2B505A8E9222BDFAD16C697 implements org.drools.model.functions.Block1<org.acme.travel.Traveller>, org.drools.model.functions.HashedExpression {

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
