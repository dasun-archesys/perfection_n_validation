package defaultPackage;

import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;
import org.acme.travel.Traveller;
import static defaultPackage.Rules6324881d1ea54fdb8686e664094bde94.*;
import static defaultPackage.Rules6324881d1ea54fdb8686e664094bde94.*;

public class Rules6324881d1ea54fdb8686e664094bde94_rule_Don_39t_32process_32travellers_32from_32US {

    /**
     * Rule name: Don't process travellers from US
     */
    public static org.drools.model.Rule rule_Don_39t_32process_32travellers_32from_32US() {
        final org.drools.model.Variable<org.acme.travel.Traveller> var_$traveller = D.declarationOf(org.acme.travel.Traveller.class,
                                                                                                    DomainClassesMetadata6324881d1ea54fdb8686e664094bde94.org_acme_travel_Traveller_Metadata_INSTANCE,
                                                                                                    "$traveller");
        org.drools.model.Rule rule = D.rule("defaultPackage",
                                            "Don't process travellers from US")
                                      .attribute(org.drools.model.Rule.Attribute.RULEFLOW_GROUP,
                                                 "travellers")
                                      .build(D.pattern(var_$traveller).expr("GENERATED_1431ED0539270BF7254590AD8439205F",
                                                                            defaultPackage.P9E.LambdaPredicate9E4006E3F9D05452CFA82FDDD1F411D4.INSTANCE,
                                                                            D.alphaIndexedBy(boolean.class,
                                                                                             org.drools.model.Index.ConstraintType.EQUAL,
                                                                                             DomainClassesMetadata6324881d1ea54fdb8686e664094bde94.org_acme_travel_Traveller_Metadata_INSTANCE.getPropertyIndex("processed"),
                                                                                             defaultPackage.P02.LambdaExtractor02E101E72AB3F7F5ACD6251322D90AE5.INSTANCE,
                                                                                             false),
                                                                            D.reactOn("processed")).expr("GENERATED_68191149A3CDE5A95B4E42CAFC6EA789",
                                                                                                         defaultPackage.PDA.LambdaPredicateDA452B0E8F479CA14C5F28248EBE68B1.INSTANCE,
                                                                                                         D.alphaIndexedBy(java.lang.String.class,
                                                                                                                          org.drools.model.Index.ConstraintType.EQUAL,
                                                                                                                          DomainClassesMetadata6324881d1ea54fdb8686e664094bde94.org_acme_travel_Traveller_Metadata_INSTANCE.getPropertyIndex("nationality"),
                                                                                                                          defaultPackage.P93.LambdaExtractor93CAA26A8EE55995C8A9A6688C636192.INSTANCE,
                                                                                                                          "American"),
                                                                                                         D.reactOn("nationality")),
                                             D.on(var_$traveller).execute(defaultPackage.PE3.LambdaConsequenceE3A575D6D2B505A8E9222BDFAD16C697.INSTANCE));
        return rule;
    }
}
