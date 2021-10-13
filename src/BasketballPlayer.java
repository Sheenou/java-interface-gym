public class BasketballPlayer extends Athlete{
    protected BasketballPosition position;
    protected DominantHand dominantHand;

    public BasketballPlayer(String firstName, String lastName, Gender gender, float weight, float height, BasketballPosition position, DominantHand dominantHand) {
        super(firstName, lastName, gender, weight, height);
        this.position = position;
        this.dominantHand = dominantHand;
    }

    public void trains() {
        System.out.println(this.firstName + " " + this.lastName + " trains shooting at a basket.");
    }

    @Override
    public String toString() {
        return "BasketballPlayer{" +
                "position='" + position + '\'' +
                ", dominantHand='" + dominantHand + "\' " +
                super.toString() +
                '}';
    }
}
