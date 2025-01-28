package Person;

import java.util.Calendar;

public class Person {
    private String FirstName;
    private String Lastname;
    private String IDNum;
    private String Title;
    private int YOB;

    public Person(String firstname, String lastname, String IDNum, String title, int YOB) {
        this.FirstName = firstname;
        this.Lastname = lastname;
        this.IDNum = IDNum;
        this.Title = title;
        this.YOB = YOB;
    }
    public boolean YOBLimit() {
        return (YOB > 1940 && YOB < 2000);
    }
    public String fullName() {
        return FirstName + " " + Lastname;
    }
    public String formalName() {
        return Title + " " + fullName();
    }
    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - YOB;
    }
    public String getAge(int year) {

        if (!(year < YOB || YOB < 0))
        {
            int age = year - YOB;
            return "Age in " + year + ": " + age + " years";
        }
        else {
            return "Invalid YOB";
        }
    }

    public String toCSVDataRecord() {
        return FirstName + "," + Lastname + "," + IDNum + "," + Title + "," + YOB;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;
        return YOB == person.YOB &&
                FirstName.equals(person.FirstName) &&
                Lastname.equals(person.Lastname) &&
                Title.equals(person.Title) &&
                IDNum.equals(person.IDNum);

    }

    @Override
    public String toString() {
        return Title + ", " + FirstName + ", " + Lastname + ", "  + "(ID: " + IDNum + "), Born: " + YOB;
    }
    public String toXML() {
        return "<Person>" +
                "<FirstName>" + FirstName + "</FirstName>" +
                "<Lastname>" + Lastname + "</Lastname>" +
                "<IDNum>" + IDNum + "</IDNum>" +
                "<Title>" + Title + "</Title>" +
                "<YOB>" + YOB + "</YOB>" +
                "</Person>";
    }

    public String toJSON()  {
        return "{" +
                "\"FirstName\": \"" + FirstName + "\"," +
                "\"Lastname\": \"" + Lastname + "\"," +
                "\"IDNum\": \"" + IDNum + "\"," +
                "\"Title\": \"" + Title + "\"," +
                "\"YOB\": " + YOB +
                "}";
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getIDNum() {
        return IDNum;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }



}


