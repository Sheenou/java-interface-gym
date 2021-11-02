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

    public boolean addAthlete(Athlete athlete) {
        try {
            this.athletes.add(athlete);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean removeAthlete(int index) {
        try {
            this.athletes.remove(index);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public String getAthletes() { return athletes.toString(); }

    public void athleteComes(int index) { this.athletes.get(index).comes(); }

    public void athleteTrains(int index) { this.athletes.get(index).trains(); }

    public void athleteLeaves(int index) { this.athletes.get(index).leaves(); }

    public void printAthlete(int index) { System.out.println(this.athletes.get(index)); }

    public void setAthleteTimetable(int index, int day, double trainingStart, double trainingEnd) { this.athletes.get(index).setTimetable(day, trainingStart, trainingEnd); }

    public void printAthleteTimetable(int index) { this.athletes.get(index).printTimetable(); }

    public int findAthlete(String firstName, String lastName) {
        int index = -1;
        for (Athlete ath : this.athletes) {
            if (firstName.equals(ath.firstName) && lastName.equals(ath.lastName)) {
                index = this.athletes.indexOf(ath);
            }
        }
        return index;
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
