import java.util.Scanner;

public class UserInterface {

    private NameGenerator name;
    private Scanner scan;

    public UserInterface(Scanner scan, NameGenerator name) {

        this.name = name;
        this.scan = scan;
    }

    public void start() {

        while (true) {

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

    public void processCommand(int command) {

        if (Integer.valueOf(command) == 1) {

            System.out.println(name.generateName());

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

                    System.out.println(name.generateName());

                } else {

                    System.out.println("Invalid input.");
                }
            }

        } else if (Integer.valueOf(command) == 2) {

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

                System.out.println(name.generateName(Integer.valueOf(input)));
            }

        } else if (Integer.valueOf(command) == 3) {

            while (true) {

                System.out.println("Starting character? Blank: Exit");
                String input = scan.nextLine();

                if (input.isEmpty()) {
                    break;
                }

                if (name.genNameChosenLetter(input) == null) {
                    System.out.println("Invalid input.");
                    continue;
                }

                System.out.println(name.genNameChosenLetter(input));
            }

        } else if (Integer.valueOf(command) == 4) {

            while (true) {

                System.out.println("What name? Blank: Exit");
                String input = scan.nextLine();

                if (input.isEmpty()) {
                    break;
                }
                name.generateGivenName(input);
            }

        } else if (Integer.valueOf(command) == 5) {

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

                name.generateMultiple(Integer.valueOf(input1), Integer.valueOf(input2));
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

                this.name.genUniqueNames(Integer.valueOf(input));
            }
        }
    }
}
