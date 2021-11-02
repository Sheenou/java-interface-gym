package msinogl.gym.base;

abstract public class Athlete implements IMovement {
    protected String firstName;
    protected String lastName;
    protected Gender gender;
    protected float weight;
    protected float height;
    protected double[][] timetable;


    public Athlete(String firstName, String lastName, Gender gender, float weight, float height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.timetable = new double[7][2];
    }

    public void setTimetable(int day, double trainingStart, double trainingEnd) {
        this.timetable[day][0] = trainingStart;
        this.timetable[day][1] = trainingEnd;
    }

    @Override
    public void comes() {
        System.out.println(this.firstName + " " + this.lastName + " arrived.");
    }

    @Override
    abstract public void trains();

    @Override
    public void leaves() {
        System.out.println(this.firstName + " " + this.lastName + " left.");
    }

    public void printTimetable() {
        int i = 0;
        System.out.println("MON: " + this.timetable[i][0] + " - " + this.timetable[i][1]);
        i++;
        System.out.println("TUE: " + this.timetable[i][0] + " - " + this.timetable[i][1]);
        i++;
        System.out.println("WED: " + this.timetable[i][0] + " - " + this.timetable[i][1]);
        i++;
        System.out.println("THU: " + this.timetable[i][0] + " - " + this.timetable[i][1]);
        i++;
        System.out.println("FRI: " + this.timetable[i][0] + " - " + this.timetable[i][1]);
        i++;
        System.out.println("SAT: " + this.timetable[i][0] + " - " + this.timetable[i][1]);
        i++;
        System.out.println("SUN: " + this.timetable[i][0] + " - " + this.timetable[i][1]);
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
