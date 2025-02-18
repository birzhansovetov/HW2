import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private List<Item> items;
    private HashMap<String, Room> exit;
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.exit = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void addExit(String direction, Room room) {
        exit.put(direction.toLowerCase(), room);

    }
    public Room getExit(String direction) {
        return exit.get(direction.toLowerCase());
    }
    public HashMap<String, Room> getExits() {
        return exit;
    }
    public String describe() {
        return description;
    }
    public List<Item> getItems() {
        return items;
    }
}
