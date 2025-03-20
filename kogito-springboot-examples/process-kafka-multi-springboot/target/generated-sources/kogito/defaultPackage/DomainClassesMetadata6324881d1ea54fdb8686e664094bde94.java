package defaultPackage;
public class DomainClassesMetadata6324881d1ea54fdb8686e664094bde94 {

    public static final org.drools.model.DomainClassMetadata org_acme_travel_Traveller_Metadata_INSTANCE = new org_acme_travel_Traveller_Metadata();
    private static class org_acme_travel_Traveller_Metadata implements org.drools.model.DomainClassMetadata {

        @Override
        public Class<?> getDomainClass() {
            return org.acme.travel.Traveller.class;
        }

        @Override
        public int getPropertiesSize() {
            return 6;
        }

        @Override
        public int getPropertyIndex( String name ) {
            switch(name) {
                case "this": return 0;
                case "email": return 1;
                case "firstName": return 2;
                case "lastName": return 3;
                case "nationality": return 4;
                case "processed": return 5;
             }
             throw new RuntimeException("Unknown property '" + name + "' for class class class org.acme.travel.Traveller");
        }
    }
}