package defaultPackage;

import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;
import org.acme.travel.Traveller;
import static defaultPackage.Rules30aa1c8810334f01bf31eb3a36b3cdf9.*;
import static defaultPackage.Rules30aa1c8810334f01bf31eb3a36b3cdf9.*;

public class Rules30aa1c8810334f01bf31eb3a36b3cdf9_rule_Don_39t_32process_32travellers_32from_32US {

    /**
     * Rule name: Don't process travellers from US
     */
    public static org.drools.model.Rule rule_Don_39t_32process_32travellers_32from_32US() {
        final org.drools.model.Variable<org.acme.travel.Traveller> var_$traveller = D.declarationOf(org.acme.travel.Traveller.class,
                                                                                                    DomainClassesMetadata30aa1c8810334f01bf31eb3a36b3cdf9.org_acme_travel_Traveller_Metadata_INSTANCE,
                                                                                                    "$traveller");
        org.drools.model.Rule rule = D.rule("defaultPackage",
                                            "Don't process travellers from US")
                                      .attribute(org.drools.model.Rule.Attribute.RULEFLOW_GROUP,
                                                 "travellers")
                                      .build(D.pattern(var_$traveller).expr("GENERATED_1431ED0539270BF7254590AD8439205F",
                                                                            defaultPackage.P4F.LambdaPredicate4FCDD2EE4DE7440ACC81FB7AFC09B175.INSTANCE,
                                                                            D.alphaIndexedBy(boolean.class,
                                                                                             org.drools.model.Index.ConstraintType.EQUAL,
                                                                                             DomainClassesMetadata30aa1c8810334f01bf31eb3a36b3cdf9.org_acme_travel_Traveller_Metadata_INSTANCE.getPropertyIndex("processed"),
                                                                                             defaultPackage.P76.LambdaExtractor76CF2D70108B33EED784AC824067BABE.INSTANCE,
                                                                                             false),
                                                                            D.reactOn("processed")).expr("GENERATED_68191149A3CDE5A95B4E42CAFC6EA789",
                                                                                                         defaultPackage.PA5.LambdaPredicateA56A29D1824FB84DB3A63B724964357F.INSTANCE,
                                                                                                         D.alphaIndexedBy(java.lang.String.class,
                                                                                                                          org.drools.model.Index.ConstraintType.EQUAL,
                                                                                                                          DomainClassesMetadata30aa1c8810334f01bf31eb3a36b3cdf9.org_acme_travel_Traveller_Metadata_INSTANCE.getPropertyIndex("nationality"),
                                                                                                                          defaultPackage.PA8.LambdaExtractorA8D2040D458EC420AA9C59276927B2C8.INSTANCE,
                                                                                                                          "American"),
                                                                                                         D.reactOn("nationality")),
                                             D.on(var_$traveller).execute(defaultPackage.PA4.LambdaConsequenceA40E947C048AE280567B72590F7E3028.INSTANCE));
        return rule;
    }
}
