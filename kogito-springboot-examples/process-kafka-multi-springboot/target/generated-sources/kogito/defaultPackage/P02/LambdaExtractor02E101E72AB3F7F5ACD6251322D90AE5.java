package defaultPackage.P02;


import static defaultPackage.Rules6324881d1ea54fdb8686e664094bde94.*;
import org.acme.travel.Traveller;
import defaultPackage.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaExtractor02E101E72AB3F7F5ACD6251322D90AE5 implements org.drools.model.functions.Function1<org.acme.travel.Traveller, Boolean>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "4EA63A03EF2D2D0FAF966B645D8C744C";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public Boolean apply(org.acme.travel.Traveller _this) {
        return _this.isProcessed();
    }
}
