package be.jidoka.clean.code.labs.movie;

public class Ticket {

    private static final double GENERAL_ADMISSION = 11.0;
    private static final double STUDENT_ADMISSION = 8.0;
    private static final double SENIOR_AMDISSION = 6.0;
    private static final double CHILD_ADMISSION = 5.5;

    private static final int MIN_SENIOR_AGE = 65;
    private static final int MAX_CHILD_AGE = 12;

    private int age;
    private final boolean student;


    public Ticket(int age, boolean student) {
        this.age = age;
        this.student = student;
    }


    public double calculatePrice() {

        if(age >= MIN_SENIOR_AGE){
            return SENIOR_AMDISSION;
        }
        else if(age <= MAX_CHILD_AGE){
            return CHILD_ADMISSION;
        }
        else if (student) {
            return STUDENT_ADMISSION;
        } else {
            return GENERAL_ADMISSION;
        }
    }
}
