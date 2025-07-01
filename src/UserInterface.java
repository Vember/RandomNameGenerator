import java.util.Scanner;

public class UserInterface {

    public static void start() {

        while (true) {

            Scanner scan = new Scanner(System.in);

            System.out.println("1: Generate Random Name");
            System.out.println("2: Generate For Int Given");
            System.out.println("3: Generate For Letter Given");
            System.out.println("4: Generate Until Given");
            System.out.println("5: Generate Multiple");
            System.out.println("6: Generate Unique Names Per 1m");
            System.out.println("7: Exit Program");
            String input = scan.nextLine();

            if (input.isEmpty()) {
                break;
            }

            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            if (Integer.valueOf(input) == 7 || Integer.valueOf(input) == 0) {
                break;
            }

            if (Integer.valueOf(input) > 7) {
                System.out.println("Invalid input.");
                continue;
            }

            processCommand(Integer.valueOf(input));
        }
    }

    public static void processCommand(int command) {

        Scanner scan = new Scanner(System.in);

        if (command == 1) {

            System.out.println(NameGenerator.generateName());

            while (true) {

                System.out.println("Generate another?");
                System.out.println("1: Yes");
                System.out.println("2: No");
                String input = scan.nextLine();

                if (input.equals("2")) {
                    break;

                } else if (input.isEmpty()) {
                    break;

                } else if (input.equals("1")) {

                    System.out.println(NameGenerator.generateName());

                } else {

                    System.out.println("Invalid input.");
                }
            }

        } else if (command == 2) {

            while (true) {

                System.out.println("How many characters? Blank: Exit");
                String input = scan.nextLine();

                if (input.isEmpty()) {
                    break;
                }

                try {
                    Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    continue;
                }

                if (Integer.valueOf(input) == 0) {
                    break;
                }

                System.out.println(NameGenerator.generateName(Integer.valueOf(input)));
            }

        } else if (command == 3) {

            while (true) {

                System.out.println("Starting character? Blank: Exit");
                String input = scan.nextLine();

                if (input.isEmpty()) {
                    break;
                }

                if (NameGenerator.genNameChosenLetter(input) == null) {
                    System.out.println("Invalid input.");
                    continue;
                }

                System.out.println(NameGenerator.genNameChosenLetter(input));
            }

        } else if (command == 4) {

            while (true) {

                System.out.println("What name? Blank: Exit");
                String input = scan.nextLine();

                if (input.isEmpty()) {
                    break;
                }
                NameGenerator.generateGivenName(input);
            }

        } else if (command == 5) {

            while (true) {

                System.out.println("How many names? Blank: Exit");
                String input1 = scan.nextLine();

                if (input1.isEmpty()) {
                    break;
                }

                try {
                    Integer.parseInt(input1);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    continue;
                }

                if (Integer.valueOf(input1) == 0) {
                    break;
                }

                System.out.println("How many characters per name? Blank: Exit");
                String input2 = scan.nextLine();

                if (input2.isEmpty()) {
                    break;
                }

                try {
                    Integer.parseInt(input2);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    continue;
                }

                if (Integer.valueOf(input1) == 0) {
                    break;
                }

                NameGenerator.generateMultiple(Integer.valueOf(input1), Integer.valueOf(input2));
            }

        } else {

            while (true) {

                System.out.println("How many characters in names? Blank: Exit");
                String input = scan.nextLine();

                if (input.isEmpty()) {
                    break;
                }

                try {
                    Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    continue;
                }

                if (Integer.valueOf(input) == 0) {
                    break;
                }

                NameGenerator.genUniqueNames(Integer.valueOf(input));
            }
        }
    }
}
