public class WeightLifter extends Athlete {
    protected double maxWeight;

    public WeightLifter(String firstName, String lastName, Gender gender, float weight, float height, double maxWeight) {
        super(firstName, lastName, gender, weight, height);
        this.maxWeight = maxWeight;
    }

    @Override
    public void trains() {
        System.out.println(this.firstName + " " + this.lastName + " trains lifting weights.");
    }

    @Override
    public String toString() {
        return "WeightLifter{" +
                "maximumWeight=" + maxWeight + '\'' +
                super.toString() +
                '}';
    }
}
