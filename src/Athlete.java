import java.lang.reflect.Array;
import java.util.ArrayList;

abstract public class Athlete implements IMovement {
    protected String firstName;
    protected String lastName;
    protected String gender;
    protected float weight;
    protected float height;
    protected double[][] timetable;


    public Athlete(String firstName, String lastName, String gender, float weight, float height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.timetable = new double[7][2];    // 0-1 monday, 2-3 tuesday, 4-5 wednesday...
    }

    public void setTimetable(int position, double trainingStart, double trainingEnd) {
        System.out.println(position);
        System.out.println(trainingStart);
        System.out.println(trainingEnd);

        this.timetable[position][0] = trainingStart;
        this.timetable[position][1] = trainingEnd;
    }

    @Override
    public void comes() {
        System.out.println(this.firstName + this.lastName + " arrived.");
    }

    @Override
    public void trains() {
    }

    @Override
    public void leaves() {
        System.out.println(this.firstName + this.lastName + " left.");
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
