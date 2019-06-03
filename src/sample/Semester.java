package sample;


public class Semester {
    private int number;
    private String school;
    private Topic topic;
    public Semester(int number, String school){
        this.number = number;
        this.school = school;
        this.topic = topic;
    }

    public String toString() { return this.number + ". " + this.school + " Semester";}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSchool() {
        return this.school;
    }

    public void getSchool(String school) {
        school = school;
    }

}
