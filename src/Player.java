import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String currentLocation;
    private List<String> inventory;


    public Player(String name, String startingLocation) {
        this.name = name;
        this.currentLocation = startingLocation;
        this.inventory = new ArrayList<>();
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String newLocation) {
        this.currentLocation = newLocation;
    }

    public void addItem(String item) {
        inventory.add(item);
    }

    public void removeItem(String item) {
        inventory.remove(item);
    }

    public List<String> getItems() {
        return inventory;
    }

    public void checkInventory() {
        if (inventory.isEmpty()) {
            System.out.println("You don't have any items.");
        } else {
            System.out.println("Your inventory:");
            for (String item : inventory) {
                System.out.println("- " + item);
            }
        }
    }
}
