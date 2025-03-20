package defaultPackage.P93;


import static defaultPackage.Rules6324881d1ea54fdb8686e664094bde94.*;
import org.acme.travel.Traveller;
import defaultPackage.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaExtractor93CAA26A8EE55995C8A9A6688C636192 implements org.drools.model.functions.Function1<org.acme.travel.Traveller, java.lang.String>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "E9CABFB01FBA3A521CBD45EFF13B6E39";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public java.lang.String apply(org.acme.travel.Traveller _this) {
        return _this.getNationality();
    }
}
