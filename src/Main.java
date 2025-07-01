import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        NameGenerator name = new NameGenerator();
        UserInterface ui = new UserInterface(scan, name);
        ui.start();

    }
}