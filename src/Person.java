public class Person
{
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    public Person(String IDNum, String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getIDNum(){
        return IDNum;
    }

    public void setIDNum(String IDNum){
        this.IDNum = IDNum;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public int getYOB(){
        return YOB;
    }

    public void setYOB(int YOB){
        this.YOB = YOB;
    }

    public String fullName()
    {
        return this.firstName + " " + this.lastName;
    }

    public String formalName()
    {
        return title + " " + firstName + " " + lastName;
    }

    public String getAge()
    {
        return String.valueOf(2022 - YOB);
    }

    public String getAge(int year)
    {
        return String.valueOf(YOB);
    }

    public String toCSVDataRecord()
    {
        return IDNum + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }
}
