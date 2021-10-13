public class BasketballPlayer extends Athlete{
    protected String position;
    protected String dominantHand;

    public BasketballPlayer(String firstName, String lastName, String gender, float weight, float height, String position, String dominantHand) {
        super(firstName, lastName, gender, weight, height);
        this.position = position;
        this.dominantHand = dominantHand;
    }

    public void trains() {
        System.out.println(this.firstName + this.lastName + " trains shooting at basket.");
    }

    @Override
    public String toString() {
        return "BasketballPlayer{" +
                "position='" + position + '\'' +
                ", dominantHand='" + dominantHand + '\'' +
                super.toString() +
                '}';
    }
}
