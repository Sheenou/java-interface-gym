public class BasketballPlayer extends Athlete{
    protected String position;
    protected String dominantHand;

    public BasketballPlayer(String firstName, String lastName, String gender, float weight, float height) {
        super(firstName, lastName, gender, weight, height);
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
