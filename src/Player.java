import java.util.ArrayList;
import java.util.List;


public class Player {
private String name;
private Room CurrentRoom;
List<Item> inventory;
public Player(String name,Room startingRoom) {
    this.name = name;
    inventory = new ArrayList<Item>();
    CurrentRoom = startingRoom;
}
public Room getCurrentRoom() {
    return CurrentRoom;
}

    public void setCurrentRoom(Room currentRoom) {
        this.CurrentRoom = currentRoom;
    }

    public void addItem(Item item) {
    inventory.add(item);
}
public void removeItem(Item item) {
    inventory.remove(item);
}
public List<Item> getItems() {
    return inventory;
}
public void checkInventory() {
    if (inventory.isEmpty()) {
        System.out.println("You don't have any items");
    }else {
    for (Item item : inventory) {
        System.out.println(item.getName());
    }
}
}
}
