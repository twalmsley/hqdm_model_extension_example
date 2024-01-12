# How to Use

This section shows how to use the model extension with MagmaCore.

The example creates and persists an entity from the extension JAR, then reads it from the database and compares it to the original.

```java
/**
 * A set of tests to try out the MagmaCore extension mechanism.
 */
public class MagmaCoreExtensionTests {

    // Declare an IRI base for the data to be created.
    private static final IriBase TEST_BASE = new IriBase("test", "http://example.com/test#");

    @Test
    public void test() {

        //
        // Create a MagmaCoreService with an in-memory Apache Jena database.
        //
        final var mcs = MagmaCoreServiceFactory.createWithJenaDatabase();

        //
        // The entity will be a part of a dummy possible_world, we just use the
        // IRI rather than creating the possible_world for this example.
        //
        final var possibleWorldIri = new IRI(TEST_BASE, UUID.randomUUID().toString());

        //
        // Create an IRI for the entity we want to create, then create the entity.
        //
        final var entityIri = new IRI(TEST_BASE, UUID.randomUUID().toString());
        final Thing entity = new UkLimitedCompanyImpl(entityIri);

        //
        // Set the RDF_TYPE and add the entity as a `part_of_possible_world`.
        //
        entity.addValue(RDFS.RDF_TYPE, Constants.UK_LIMITED_COMPANY_IRI);
        entity.addValue(HQDM.PART_OF_POSSIBLE_WORLD, possibleWorldIri);

        //
        // Persist the entity in the database.
        //
        mcs.runInTransaction(svc -> {
            svc.create(entity);
            return svc;
        });

        //
        // Read the entity back and assert that it matches the original.
        //
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
