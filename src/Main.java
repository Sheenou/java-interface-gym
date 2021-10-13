import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Gym gym = new Gym("Jim", 120);

        Athlete pepa = new BasketballPlayer("Pepa", "Pepovič", "muž", 69, 180, "left wing", "right");
        gym.addAthlete(pepa);
        /*
        System.out.println(gym.toString());

        pepa.setTimetable(0, 15.15, 18.20);
        pepa.printTimetable();
         */

        menu(gym);
    }

    public static void menu(Gym gym) {
        int action;
        do {
            System.out.println("1 - add an athlete"
                    +"\n2 - select an athlete"
                    +"\n3 - print gym"
                    +"\n0 - end");
            System.out.print("enter your selection: ");
            action = input.nextInt();

            switch (action) {
                case 1:
                    addAthlete(gym);
                    System.out.println("-- athlete added");
                    break;
                case 2:
                    selectAthlete(gym);
                    break;
                case 3:
                    System.out.println(gym);
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
        System.out.print("enter height: ");
        float height = input.nextFloat();

        int action;
        do {
            System.out.println("select type of athlete"+
                    "\n1 - basketball player"+
                    "\n2 - WeightLifter"+
                    "\n0 - end");
            System.out.print("enter your selection: ");
            action = input.nextInt();

            switch (action) {
                case 1:
                    System.out.print("enter player's position:");
                    String position = input.nextLine();
                    System.out.print("enter player's dominant hand:");
                    String dominantHand = input.nextLine();
                    gym.addAthlete(new BasketballPlayer(firstName, lastName, gender, weight, height, position, dominantHand));
                    break;
                case 2:
                    System.out.println("enter lifter's max lifted weight:");
                    Double maxWeight = input.nextDouble();
                    gym.addAthlete(new WeightLifter(firstName, lastName, gender, weight, height, maxWeight));
                    break;
            } action = 0;
        } while (action != 0);
    }

    public static void selectAthlete(Gym gym) {
        int athleteIndex = findAthlete(gym);
        if (athleteIndex == -1) System.out.println("-- athlete not found");
        else {
            int action;
            do {
                System.out.println("1 - remove athlete"
                        + "\n2 - print athlete"
                        + "\n3 - athlete comes"
                        + "\n4 - athlete starts training"
                        + "\n5 - athlete leaves"
                        + "\n6 - set athlete's timetable"
                        + "\n7 - print athlete's timetable"
                        + "\n0 - end");
                System.out.print("enter your selection: ");
                action = input.nextInt();

                switch (action) {
                    case 1:
                        gym.removeAthlete(athleteIndex);
                        System.out.println("-- athlete removed");
                        action = 0;
                        break;
                    case 2:
                        gym.printAthlete(athleteIndex);
                        break;
                    case 3:
                        gym.athleteComes(athleteIndex);
                        break;
                    case 4:
                        gym.athleteTrains(athleteIndex);
                        break;
                    case 5:
                        gym.athleteLeaves(athleteIndex);
                        break;
                    case 6:
                        setAthleteTimetable(gym, athleteIndex);
                        break;
                    case 7:
                        gym.printAthleteTimetable(athleteIndex);
                        break;
                }
            } while (action != 0);
        }
    }

    public static int findAthlete(Gym gym) {
        System.out.print("enter firstname: ");
        String firstName = input.next();
        System.out.print("enter lastname: ");
        String lastName = input.next();

        return gym.findAthlete(firstName, lastName);
    }

    public static void setAthleteTimetable(Gym gym, int athleteIndex) {
        int day;
        do {
            System.out.println("select day:"
                    + "\n1 - monday"
                    + "\n2 - tuesday"
                    + "\n3 - wednesday"
                    + "\n4 - thursday"
                    + "\n5 - friday"
                    + "\n6 - saturday"
                    + "\n7 - sunday"
                    + "\n0 - end");
            System.out.print("enter your selection: ");
            day = input.nextInt();
            if (day > 0 && day < 8) {
                System.out.print("enter training start time: ");
                double trainingStart = input.nextDouble();
                System.out.print("enter training end time: ");
                double trainingEnd = input.nextDouble();
                if (trainingEnd > trainingStart) gym.setAthleteTimetable(athleteIndex,day-1, trainingStart, trainingEnd);
                else System.out.println("-- training times are not valid");
            } else if (day != 0) System.out.println("-- day selection is not valid");
        } while (day != 0);
    }
}
