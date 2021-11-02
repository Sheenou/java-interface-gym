package msinogl.gym.base;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static String seperator = "----------";
    static String highlighter = "**********";

    public static void main(String[] args) {
        Gym gym = new Gym("Jim", 120);
        menu(gym);
    }

    public static void menu(Gym gym) {
        int action;

        do {
            System.out.println(highlighter + " Gym manager " + highlighter);
            System.out.println(
                    "1 - Add an athlete" + "\n" +
                            "2 - Select an athlete" + "\n" +
                            "3 - Print gym" + "\n" +
                            "0 - End");

            System.out.print("\nEnter your selection: \n");
            action = input.nextInt();

            switch (action) {
                case 1:
                    addAthlete(gym);
                    System.out.println(seperator + " Athlete added " + seperator);
                    break;
                case 2:
                    selectAthlete(gym);
                    System.out.println(seperator + " Athlete selected " + seperator);
                    break;
                case 3:
                    System.out.println(gym);
                    break;
            }
        } while (action != 0);
    }

    public static void addAthlete(Gym gym) {
        System.out.println(highlighter + " Add an athlete " + highlighter);
//        Firstname
        System.out.print("Enter the firstname: \n");
        String firstName = input.next();

//        Lastname
        System.out.print("Enter the lastname: \n");
        String lastName = input.next();

//        Gender
        int genderSelect;
        System.out.println(
                "Select gender" + "\n" +
                        "0 - Male" + "\n" +
                        "1 - Female"
        );
        genderSelect = input.nextInt();

        Gender gender;
        if (genderSelect == 0) gender = Gender.MALE;
        else gender = Gender.FEMALE;

//        Weight
        System.out.print("Enter weight: \n");
        float weight = input.nextFloat();


//        Height
        System.out.print("Enter height: \n");
        float height = input.nextFloat();

//        Type of athlete
        int action;
        do {
            System.out.println(
                    "Select the type of athlete" + "\n" +
                            "1 - Basketball player" + "\n" +
                            "2 - Weightlifter" + "\n" +
                            "0 - End"
            );
            System.out.print("\nEnter your selection: \n");
            action = input.nextInt();

            switch (action) {
                case 1:
                    int positionSelect;
                    System.out.println(
                            "Select player's position: " + "\n" +
                                    "0 - Left wing" + "\n" +
                                    "1 - Right wing" + "\n" +
                                    "2 - Center");
                    positionSelect = input.nextInt();

                    BasketballPosition position;
                    if (positionSelect == 0) position = BasketballPosition.LEFT_WING;
                    else if (positionSelect == 1) position = BasketballPosition.RIGHT_WING;
                    else position = BasketballPosition.CENTER;

                    int handSelect;
                    System.out.println(
                            "Select player's dominant hand: " + "\n" +
                                    "0 - Left" + "\n" +
                                    "1 - Right"
                    );
                    handSelect = input.nextInt();

                    DominantHand dominantHand;
                    if (handSelect == 0) dominantHand = DominantHand.LEFT;
                    else dominantHand = DominantHand.RIGHT;

                    gym.addAthlete(new BasketballPlayer(firstName, lastName, gender, weight, height, position, dominantHand));
                    break;
                case 2:
                    System.out.print("Enter lifter's heaviest lifted weight: \n");
                    Double maxWeight = input.nextDouble();

                    gym.addAthlete(new WeightLifter(firstName, lastName, gender, weight, height, maxWeight));
                    break;
            }
            action = 0;
        } while (action != 0);
    }

    public static void selectAthlete(Gym gym) {
        System.out.println(highlighter + " Select an athlete " + highlighter);
        int athleteIndex = findAthlete(gym);
        if (athleteIndex == -1) System.out.println(seperator + " Athlete is not a part of the gym " + seperator);
        else {
            int action;
            do {
                System.out.println(
                        "1 - Remove athlete" + "\n" +
                                "2 - Print athlete" + "\n" +
                                "3 - Athlete comes" + "\n" +
                                "4 - Athlete starts training" + "\n" +
                                "5 - Athlete leaves" + "\n" +
                                "6 - Set athlete's timetable" + "\n" +
                                "7 - Print athlete's timetable" + "\n" +
                                "0 - End"
                );
                System.out.print("\nEnter your selection: \n");
                action = input.nextInt();

                switch (action) {
                    case 1:
                        gym.removeAthlete(athleteIndex);
                        System.out.println(seperator + " Athlete has been removed " + seperator);
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
        System.out.print("Enter the firstname: \n");
        String firstName = input.next();

        System.out.print("Enter the lastname: \n");
        String lastName = input.next();

        return gym.findAthlete(firstName, lastName);
    }

    public static void setAthleteTimetable(Gym gym, int athleteIndex) {
        System.out.println(highlighter + " Edit an athlete's timetable " + highlighter);
        int day;
        do {
            System.out.println(
                    "Select day:" + "\n" +
                            "1 - Monday" + "\n" +
                            "2 - Tuesday" + "\n" +
                            "3 - Wednesday" + "\n" +
                            "4 - Thursday" + "\n" +
                            "5 - Friday" + "\n" +
                            "6 - Saturday" + "\n" +
                            "7 - Sunday" + "\n" +
                            "0 - End"
            );
            System.out.print("\nEnter your selection: \n");

            day = input.nextInt();
            if (day > 0 && day < 8) {
                System.out.print("\nEnter training start time: \n");
                double trainingStart = input.nextDouble();

                System.out.print("\nEnter training end time: \n");
                double trainingEnd = input.nextDouble();

                if (trainingEnd > trainingStart)
                    gym.setAthleteTimetable(athleteIndex, day - 1, trainingStart, trainingEnd);
                else System.out.println(seperator + " Training times are not valid " + seperator);
            } else if (day != 0) System.out.println(seperator + " Day selection is not valid" + seperator);
        } while (day != 0);
    }
}
