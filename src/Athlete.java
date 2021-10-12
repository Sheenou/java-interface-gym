abstract public class Athlete implements IMovement {
    protected String firstName;
    protected String lastName;
    protected String gender;
    protected float weight;
    protected float height;

    public Athlete(String firstName, String lastName, String gender, float weight, float height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public void comes() {
        System.out.println(this.firstName + this.lastName + " arrived.");
    }

    @Override
    public void trains() {
        System.out.println(this.firstName + this.lastName + " is training.");
    }

    @Override
    public void leaves() {
        System.out.println(this.firstName + this.lastName + " left.");
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
