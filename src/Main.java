//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Room hall = new Room("Hall", "A grand hall with chandeliers.");
        Room dungeon = new Room("Dungeon", "A dark, scary place.");
        Room kitchen = new Room("Kitchen", "A cozy place with a fireplace.");

        hall.addExit("north",dungeon);
        hall.addExit("west",kitchen);
        dungeon.addExit("south",hall);
        kitchen.addExit("east",hall);


        hall.addItem(new Item("sword" , "weapon with a long blade"));
        hall.addItem(new Item("bow", "you can archery"));
        kitchen.addItem(new Item("apple", "green apple"));
        dungeon.addItem(new Item("skeleton", "dead person"));

        Player player = new Player("Henry", hall);
        MUDController controller = new MUDController(player);
        controller.runGameLoop();

    }
}