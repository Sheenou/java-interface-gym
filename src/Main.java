public class Main {

    public static void main(String[] args) {
        Gym gym = new Gym("Super džim", 120);

        Athlete pepa = new BasketballPlayer("Pepa", "Pepovič", "muž", 69, 180);
        gym.newAthlete(pepa);

        System.out.println(gym.toString());
    }
}
