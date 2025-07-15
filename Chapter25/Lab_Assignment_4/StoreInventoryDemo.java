package Chapter25.Lab_Assignment_4;

public class StoreInventoryDemo {


    public static void main(String[] args) {

        StoreInventory store = new StoreInventory();

        // Adding items to the inventory
        store.addItem(30006, "Apple");
        store.addItem(46181, "Banana");
        store.addItem(61123, "Orange");
        store.addItem(1002, "Milk");
        store.addItem(1003, "Bread");
        store.addItem(1001, "Eggs");
        store.addItem(2000, "Butter");


        System.out.println("Inventory:");
        store.printInventory();

        System.out.println("\n");
        System.out.println("\nHas item 1002? " + store.hasItem(30006));
        System.out.println("Has item 9999? " + store.hasItem(1003));

        store.printInventory();
       
    }
    
    

}
