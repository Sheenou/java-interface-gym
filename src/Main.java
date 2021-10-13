import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Gym gym = new Gym("Jim", 120);
        menu(gym);
    }

    public static void menu(Gym gym) {
        int action;
        do {
            System.out.println("1 - add an athlete" + "\n" +
                    "2 - select an athlete" + "\n" +
                    "3 - print gym" + "\n" +
                    "0 - end");
            System.out.print("enter your selection: \n");
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
        System.out.print("enter firstname: \n");
        String firstName = input.next();
        System.out.print("enter lastname: \n");
        String lastName = input.next();

        int genderSelect;
        System.out.println("select gender: " + "\n" +
                    "0 - male" + "\n" +
                    "1 - female");
        genderSelect = input.nextInt();
        Gender gender;
        if (genderSelect == 0) gender = Gender.MALE;
        else gender = Gender.FEMALE;

        System.out.print("enter weight: \n");
        float weight = input.nextFloat();
        System.out.print("enter height: \n");
        float height = input.nextFloat();

        int action;
        do {
            System.out.println("select type of athlete" + "\n" +
                    "1 - basketball player" + "\n" +
                    "2 - WeightLifter" + "\n" +
                    "0 - end");
            System.out.print("enter your selection: \n");
            action = input.nextInt();

            switch (action) {
                case 1:
                    int positionSelect;
                    System.out.println("select player's position: " + "\n" +
                            "0 - left wing" + "\n" +
                            "1 - right wing" + "\n" +
                            "2 - center");
                    positionSelect = input.nextInt();
                    BasketballPosition position;
                    if (positionSelect == 0) position = BasketballPosition.LEFT_WING;
                    else if (positionSelect == 1) position = BasketballPosition.RIGHT_WING;
                    else position = BasketballPosition.CENTER;

                    int handSelect;
                    System.out.println("select player's dominant hand: " + "\n" +
                            "0 - left" + "\n" +
                            "1 - right");
                    handSelect = input.nextInt();
                    DominantHand dominantHand;
                    if (handSelect == 0) dominantHand = DominantHand.LEFT;
                    else dominantHand = DominantHand.RIGHT;

                    gym.addAthlete(new BasketballPlayer(firstName, lastName, gender, weight, height, position, dominantHand));
                    break;
                case 2:
                    System.out.print("enter lifter's max lifted weight: \n");
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
                System.out.println("1 - remove athlete" + "\n" +
                        "2 - print athlete" + "\n" +
                        "3 - athlete comes" + "\n" +
                        "4 - athlete starts training" + "\n" +
                        "5 - athlete leaves" + "\n" +
                        "6 - set athlete's timetable" + "\n" +
                        "7 - print athlete's timetable" + "\n" +
                        "0 - end");
                System.out.print("enter your selection: \n");
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
        System.out.print("enter firstname: \n");
        String firstName = input.next();
        System.out.print("enter lastname: \n");
        String lastName = input.next();

        return gym.findAthlete(firstName, lastName);
    }

    public static void setAthleteTimetable(Gym gym, int athleteIndex) {
        int day;
        do {
            System.out.println("select day:" + "\n" +
                    "1 - monday" + "\n" +
                    "2 - tuesday" + "\n" +
                    "3 - wednesday" + "\n" +
                    "4 - thursday" + "\n" +
                    "5 - friday" + "\n" +
                    "6 - saturday" + "\n" +
                    "7 - sunday" + "\n" +
                    "0 - end");
            System.out.print("enter your selection: \n");
            day = input.nextInt();
            if (day > 0 && day < 8) {
                System.out.print("enter training start time: \n");
                double trainingStart = input.nextDouble();
                System.out.print("enter training end time: \n");
                double trainingEnd = input.nextDouble();
                if (trainingEnd > trainingStart) gym.setAthleteTimetable(athleteIndex,day-1, trainingStart, trainingEnd);
                else System.out.println("-- training times are not valid");
            } else if (day != 0) System.out.println("-- day selection is not valid");
        } while (day != 0);
    }
}
