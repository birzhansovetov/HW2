

import java.util.List;
import java.util.Scanner;

public class MUDController {
    private final Player player;
    private boolean running;

    public MUDController(Player player) {
        // Initialize fields here (if needed)
        this.player = player;
        this.running = true;
    }

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Game! ");
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
            checkInventory(player);
        } else if (command.equals("help")) {
            showHelp();
        } else if (command.equals("quit")) {
            running = false;
        } else {
            System.out.println("Unknown command: " + input);
        }

    }


    private void lookAround() {
        Room currentRoom = player.getCurrentRoom();
        System.out.println(currentRoom.describe());
        List<Item> items = currentRoom.getItems();
        if (items.isEmpty()){
            System.out.println("There are no items in this room");
        }else {
            for (Item item : items) {
                System.out.println("Item: " + item.getName());

            }
        }
        if (!currentRoom.getExits().isEmpty()){
            System.out.println("Exits: " + String.join(", ", currentRoom.getExits().keySet()));
       }else {
           System.out.println("There are no exits in this room");
       }
    }

    private void move(String direction) {
        Room currentRoom = player.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("Moved " + direction + " to " + nextRoom.getName());
        }else {
            System.out.println("No exits at " + direction);
        }
    }


    private void pickUp(String arg) {
        String name = arg.startsWith("up") ? arg.substring(3) : arg;
        Room currentRoom = player.getCurrentRoom();
        Item item = currentRoom.getItem(name);
        if (item != null) {
            System.out.println("Picked up " + name);
        }else {
            System.out.println("No such item " + name);
        }
        player.addItem(item);

        currentRoom.removeItem(item);

    }

    private void checkInventory(Player inventory) {
        if (inventory == null) {
            System.out.println("You don't have any items");
        }else {
           for (Item item : inventory.getItems()) {
               System.out.println(item.getName());
           }
        }
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