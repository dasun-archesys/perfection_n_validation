package defaultPackage.P76;


import static defaultPackage.Rules30aa1c8810334f01bf31eb3a36b3cdf9.*;
import org.acme.travel.Traveller;
import defaultPackage.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaExtractor76CF2D70108B33EED784AC824067BABE implements org.drools.model.functions.Function1<org.acme.travel.Traveller, Boolean>, org.drools.model.functions.HashedExpression {

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
