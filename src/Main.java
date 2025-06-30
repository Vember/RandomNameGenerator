import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Name names = new Name();
        UserInterface ui = new UserInterface(scan, names);
        ui.start();

    }
}