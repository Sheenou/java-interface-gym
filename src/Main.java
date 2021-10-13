import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Gym gym = new Gym("Jim", 120);

        menu(gym);
        System.out.println(gym);
    }

    public static void menu(Gym gym) {
        int action = -1;
        do {
            System.out.println("1 - Add an athlete" + "\n" +
                            "2 - Remove an athlete" + "\n" +
                            "3 - Print all athletes" + "\n" +
                            "0 - Exit"
            );

            System.out.print("\nEnter your selection: \n");
            action = input.nextInt();

            switch (action) {
                case 1:
                    addAthlete(gym);
                    break;
            }
        } while (action != 0);
    }

    public static void addAthlete(Gym gym) {
        System.out.print("Enter the firstname: \n");
        String firstName = input.next();
        System.out.print("Enter the lastname: \n");
        String lastName = input.next();
        // TODO FIX
        System.out.print("Enter the gender: \n");
        System.out.print("Enter the weight: \n");
        float weight = input.nextFloat();
        System.out.print("Enter the height: \n");
        float height = input.nextFloat();

        int action;
        do {
            System.out.println(
                    "Select the type of the athlete" + "\n" +
                    "1 - Basketball player" + "\n" +
                    "0 - End");

            System.out.print("\nEnter your selection: \n");
            action = input.nextInt();

            switch (action) {
                case 1:
                    // TODO fix position and dominant hand selection
                    System.out.println("Enter the player's position:");
                    System.out.println("Enter the player's dominant hand:");
                    gym.addAthlete(new BasketballPlayer(firstName, lastName, Gender.MALE, weight, height, BasketballPosition.RIGHT_WING, DominantHand.RIGHT));
                    action = 0;
                    break;
            }
        } while (action != 0);
    }
}
