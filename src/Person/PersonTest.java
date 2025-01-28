package Person;

import org.junit.jupiter.api.Assertions;

class PersonTest {

    Person p1, p2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        p1 = new Person("Josh","Nyamsi","000001", "Mr.", 2002);
    }

    @org.junit.jupiter.api.Test
    void fullName() {
        String expected = "Josh Nyamsi";
        Assertions.assertEquals(expected, p1.fullName());
    }

    @org.junit.jupiter.api.Test
    void formalName() {
        String expected = "Mr. Josh Nyamsi";
        Assertions.assertEquals(expected, p1.formalName());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
        int expected = 23;
        Assertions.assertEquals(expected, p1.getAge());
    }

    @org.junit.jupiter.api.Test
    void toCSVDataRecord() {
        String expected = "Josh,Nyamsi,000001,Mr.,2002";
        Assertions.assertEquals(expected, p1.toCSVDataRecord());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        p2 = new Person("Josh","Nyamsi","000001", "Mr.", 2002);
        Assertions.assertEquals(p1, p2);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        String expected = "Mr., Josh, Nyamsi, (ID: 000001), Born: 2002";
        Assertions.assertEquals(expected, p1.toString());
    }

    @org.junit.jupiter.api.Test
    void toXML() {
        String expected = "<Person>" +
                "<FirstName>Josh</FirstName>" +
                "<Lastname>Nyamsi</Lastname>" +
                "<IDNum>000001</IDNum>" +
                "<Title>Mr.</Title>" +
                "<YOB>2002</YOB>" +
                "</Person>";
        Assertions.assertEquals(expected, p1.toXML());
    }

    @org.junit.jupiter.api.Test
    void toJSON() {
        String expected = "{" +
                "\"FirstName\": \"Josh\"," +
                "\"Lastname\": \"Nyamsi\"," +
                "\"IDNum\": \"000001\"," +
                "\"Title\": \"Mr.\"," +
                "\"YOB\": 2002" +
                "}";
        Assertions.assertEquals(expected, p1.toJSON());
    }

    @org.junit.jupiter.api.Test
    void setFirstName() {
        p1.setFirstName("Josh");
        Assertions.assertEquals("Josh", p1.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void setLastname() {
        p1.setLastname("Nyamsi");
        Assertions.assertEquals("Nyamsi", p1.getLastname());
    }

    @org.junit.jupiter.api.Test
    void setTitle() {
        p1.setTitle("Mr.");
        Assertions.assertEquals("Mr.", p1.getTitle());
    }

    @org.junit.jupiter.api.Test
    void setYOB() {
        p1.setYOB(2002);
        Assertions.assertEquals(2002, p1.getYOB());
    }
}