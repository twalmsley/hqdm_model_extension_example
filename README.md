# How to Use

This section shows how to use the model extension with MagmaCore.

The example creates and persists an entity from the extension JAR, then reads it from the database and compares it to the original.

```java
/**
 * A set of tests to try out the MagmaCore extension mechanism.
 */
public class MagmaCoreExtensionTests {

    private static final IriBase TEST_BASE = new IriBase("test", "http://example.com/test#");

    @Test
    public void test() {
        final var mcs = MagmaCoreServiceFactory.createWithJenaDatabase();

        final var possibleWorldIri = new IRI(TEST_BASE, UUID.randomUUID().toString());
        final var entityIri = new IRI(TEST_BASE, UUID.randomUUID().toString());
        final Thing entity = new UkLimitedCompanyImpl(entityIri);

        entity.addValue(RDFS.RDF_TYPE, Constants.UK_LIMITED_COMPANY_IRI);
        entity.addValue(HQDM.PART_OF_POSSIBLE_WORLD, possibleWorldIri);

        mcs.runInTransaction(svc -> {
            svc.create(entity);
            return svc;
        });

        mcs.runInTransaction(svc -> {
            final var restoredEntity = svc.get(entityIri);

            assertNotNull(restoredEntity);
            assertTrue(restoredEntity instanceof UkLimitedCompany);
            assertEquals(entity, restoredEntity);
            return svc;
        });
    }
}
```
