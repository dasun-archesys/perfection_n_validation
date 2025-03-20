package defaultPackage.PA8;


import static defaultPackage.Rules30aa1c8810334f01bf31eb3a36b3cdf9.*;
import org.acme.travel.Traveller;
import defaultPackage.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaExtractorA8D2040D458EC420AA9C59276927B2C8 implements org.drools.model.functions.Function1<org.acme.travel.Traveller, java.lang.String>, org.drools.model.functions.HashedExpression {

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
