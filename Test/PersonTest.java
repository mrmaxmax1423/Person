import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Person("000001", "Bob", "Tester1", "Mr.", 1995);
        p2 = new Person("000002", "Sally", "Tester2", "Mrs.", 1975);
        p3 = new Person("000003", "Ted", "Tester3", "Mr.", 1960);
        p4 = new Person("000004", "Jim", "Tester4", "Mr.", 1965);
        p5 = new Person("000005", "Cindy", "Tester5", "Mrs.", 1970);
        p6 = new Person("000006", "Jane", "Tester6", "Mrs.", 1975);
    }


    @Test
    void fullName() {
        assertEquals("Jim Tester4", p4.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mrs. Sally Tester2", p2.formalName());
    }

    @Test
    void getAge() {
        assertEquals("27", p1.getAge());
    }

    @Test
    void testGetAge() {

    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000006, Jane, Tester6, Mrs., 1975", p6.toCSVDataRecord());
    }

    @Test
    void setIDNum() {
        p2.setIDNum("000009");
        assertEquals("000009", p2.getIDNum());
    }

    @Test
    void setFirstName() {
        p2.setFirstName("Claire");
        assertEquals("Claire", p2.getFirstName());
    }

    @Test
    void setLastName() {
        p4.setLastName("Tester8");
        assertEquals("Tester8", p4.getLastName());
    }

    @Test
    void setTitle() {
        p6.setTitle("Ms.");
        assertEquals("Ms.", p6.getTitle());
    }

    @Test
    void setYOB() {
        p6.setYOB(1988);
        assertEquals(1988, p6.getYOB());
    }

}