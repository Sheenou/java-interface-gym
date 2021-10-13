import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Gym gym = new Gym("Jim", 120);

        Athlete pepa = new BasketballPlayer("Pepa", "Pepovič", "muž", 69, 180, "left wing", "right");
        gym.addAthlete(pepa);

        System.out.println(gym.toString());

        pepa.setTimetable(0, 15.15, 18.20);
        pepa.printTimetable();

        menu(gym);
        System.out.println(gym);
    }

    public static void menu(Gym gym) {
        int action = -1;
        do {
            System.out.println("1 - add an athlete"
                    +"\n2 - remove an athlete"
                    +"\n0 - end");
            System.out.print("enter your selection: ");
            action = input.nextInt();

            switch (action) {
                case 1:
                    addAthlete(gym);
                    break;
            }
        } while (action != 0);
    }

    public static void addAthlete(Gym gym) {
        System.out.print("enter firstname: ");
        String firstName = input.next();
        System.out.print("enter lastname: ");
        String lastName = input.next();
        System.out.print("enter gender: ");
        String gender = input.next();
        System.out.print("enter weight: ");
        float weight = input.nextFloat();
        System.out.println(weight);
        System.out.print("enter height: ");
        float height = input.nextFloat();

        int action;
        do {
            System.out.println("select type of athlete"+
                    "\n1 - basketball player"+
                    "\n0 - end");
            System.out.print("enter your selection: ");
            action = input.nextInt();

            switch (action) {
                case 1:
                    System.out.println("enter player's position:");
                    String position = input.next();
                    System.out.println("enter player's dominant hand:");
                    String dominantHand = input.next();
                    gym.addAthlete(new BasketballPlayer(firstName, lastName, gender, weight, height, position, dominantHand));
                    break;
            }
        } while (action != 0);
    }
}
