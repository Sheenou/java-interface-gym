import java.util.ArrayList;

public class Gym {
    private String name;
    private ArrayList<Athlete> athletes;
    private float entryCost;

    public Gym(String name, float entryCost) {
        this.name = name;
        this.entryCost = entryCost;
        this.athletes = new ArrayList<>();
    }

    public boolean newAthlete(Athlete athlete) {
        try {
            this.athletes.add(athlete);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Gym{" +
                "name='" + name + '\'' +
                ", athletes=" + athletes +
                ", entryCost=" + entryCost +
                '}';
    }
}
