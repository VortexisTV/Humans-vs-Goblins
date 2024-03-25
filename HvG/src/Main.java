import java.util.Scanner;


public class Main {
    private static GameWorld gameWorld = new GameWorld(10);

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);

        do {
            gameWorld.displayWorld();
            System.out.println("Move with WASD. Type 'quit' to exit.");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("quit")) {
                System.out.println(gameResponse(input));
            }
        } while (!input.equalsIgnoreCase("quit"));

        scanner.close();
    }

    public static String gameResponse(String choice) {
        if (choice.equals("w")) {
            gameWorld.movePlayer("w");
        }
        if (choice.equals("s")) {
            gameWorld.movePlayer("s");
        }
        if (choice.equals("a")) {
            gameWorld.movePlayer("a");
        }
        if (choice.equals("d")) {
            gameWorld.movePlayer("d");
        }
        return "";

    }
}
