package defaultPackage;

import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;
import org.acme.travel.Traveller;
import static defaultPackage.Rules30aa1c8810334f01bf31eb3a36b3cdf9.*;
import static defaultPackage.Rules30aa1c8810334f01bf31eb3a36b3cdf9.*;

public class Rules30aa1c8810334f01bf31eb3a36b3cdf9_rule_Process_32travellers {

    /**
     * Rule name: Process travellers
     */
    public static org.drools.model.Rule rule_Process_32travellers() {
        final org.drools.model.Variable<org.acme.travel.Traveller> var_$traveller = D.declarationOf(org.acme.travel.Traveller.class,
                                                                                                    DomainClassesMetadata30aa1c8810334f01bf31eb3a36b3cdf9.org_acme_travel_Traveller_Metadata_INSTANCE,
                                                                                                    "$traveller");
        org.drools.model.Rule rule = D.rule("defaultPackage",
                                            "Process travellers")
                                      .attribute(org.drools.model.Rule.Attribute.RULEFLOW_GROUP,
                                                 "travellers")
                                      .build(D.pattern(var_$traveller).expr("GENERATED_1431ED0539270BF7254590AD8439205F",
                                                                            defaultPackage.P4F.LambdaPredicate4FCDD2EE4DE7440ACC81FB7AFC09B175.INSTANCE,
                                                                            D.alphaIndexedBy(boolean.class,
                                                                                             org.drools.model.Index.ConstraintType.EQUAL,
                                                                                             DomainClassesMetadata30aa1c8810334f01bf31eb3a36b3cdf9.org_acme_travel_Traveller_Metadata_INSTANCE.getPropertyIndex("processed"),
                                                                                             defaultPackage.P76.LambdaExtractor76CF2D70108B33EED784AC824067BABE.INSTANCE,
                                                                                             false),
                                                                            D.reactOn("processed")).expr("GENERATED_7A4D786786CA592335131B19292DCAA2",
                                                                                                         defaultPackage.P95.LambdaPredicate95BE56602FA3E9952521BC27CDBE6F42.INSTANCE,
                                                                                                         D.alphaIndexedBy(java.lang.String.class,
                                                                                                                          org.drools.model.Index.ConstraintType.NOT_EQUAL,
                                                                                                                          DomainClassesMetadata30aa1c8810334f01bf31eb3a36b3cdf9.org_acme_travel_Traveller_Metadata_INSTANCE.getPropertyIndex("nationality"),
                                                                                                                          defaultPackage.PA8.LambdaExtractorA8D2040D458EC420AA9C59276927B2C8.INSTANCE,
                                                                                                                          "American"),
                                                                                                         D.reactOn("nationality")),
                                             D.on(var_$traveller).execute(defaultPackage.P94.LambdaConsequence94B055A6B152307CC21B69B486EB2B64.INSTANCE));
        return rule;
    }
}
