

import java.util.List;
import java.util.Scanner;

public class MUDController {
    private final Player player;
    private boolean running;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Game! ");
        System.out.println("Write help for a list of commands");
        while (running) {
            System.out.println("> ");
            String input = scanner.nextLine();
            if (input.isEmpty()){
                continue;
            }
            handleInput(input);

        }
        System.out.println("Goodbye!");
    }

    public void handleInput(String input) {
        String[] parts = input.split(" ", 3);
        String command = parts[0];
        String action = (parts.length > 1) ? parts[1] : "";
        String arguments = (parts.length > 2) ? parts[2] : "";

        if (command.equals("look")) {
            lookAround();
        } else if (command.equals("move")) {
            move(action);
        } else if (command.equals("pick") && action.equals("up")) {
            pickUp(arguments);
        } else if (command.equals("inventory")) {
            checkInventory();
        } else if (command.equals("help")) {
            showHelp();
        } else if (command.equals("quit")) {
            running = false;
        } else {
            System.out.println("Unknown command: " + input);
        }

    }


    private void lookAround() {
        System.out.println("You are at" + player.getCurrentLocation());
    }

    private void move(String direction) {
        if (direction.isEmpty()) {
            System.out.println("Move where? (north, south, east, west)");
            return;
        }
        player.setCurrentLocation("Moved " + direction);
        System.out.println("You moved " + direction + ".");
    }


    private void pickUp(String item) {
        if (item.isEmpty()) {
            System.out.println("Pick up what?");
            return;
        }
        player.addItem(item);
        System.out.println("You picked up: " + item);

    }

    private void checkInventory() {
       player.checkInventory();
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("look               - Describe the current room");
        System.out.println("move <direction>   - Move in a direction (north, south, east, west)");
        System.out.println("pick up <item>     - Pick up an item from the room");
        System.out.println("inventory          - Show items in your inventory");
        System.out.println("help               - Show this help menu");
        System.out.println("quit               - Exit the game");
    }


}