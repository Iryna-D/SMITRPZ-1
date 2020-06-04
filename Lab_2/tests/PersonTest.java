import com.Functions;
import com.Person;
import org.junit.jupiter.api.Assertions;
import nl.jqno.equalsverifier.*;


class PersonTest {

    static Functions functions = new Functions();
    static String serializedPerson;
    static Person alice1;
    static Person alice2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        alice1 = new Person("Alice", 1234);
        serializedPerson = functions.serialization(alice1);
        alice2 = functions.deserialization(serializedPerson);
    }

    @org.junit.jupiter.api.Test
    void testEqualsAndHashCode() {
        EqualsVerifier.forClass(Person.class).verify();
        Assertions.assertEquals(alice1, alice2);
    }
}