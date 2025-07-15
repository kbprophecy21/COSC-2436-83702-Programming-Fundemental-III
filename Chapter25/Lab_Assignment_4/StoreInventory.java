package Chapter25.Lab_Assignment_4;

public class StoreInventory {

    private class Node {
        int itemId;
        String itemName;
        Node left, right;

        Node(int itemId, String itemName) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.left = this.right = null;
        }
    }

    private Node root;

    public StoreInventory() {
        root = null;
    }


    // --------------Methods--------------- //

    /**
     * Adds an item to the inventory.
     * If the item ID already exists, ignore the insertion.
     * @param itemId The unique identifier for the item.
     * @param itemName The itemName of the item.
     */
    void addItem(int itemId, String itemName){
        root = addRecursive(root, itemId, itemName);

    }

    private Node addRecursive(Node current, int itemId, String itemName) {
        if (current == null) {
            return new Node(itemId, itemName);
        }

        if (itemId < current.itemId) {
            current.left = addRecursive(current.left, itemId, itemName);
        } else if (itemId > current.itemId) {
            current.right = addRecursive(current.right, itemId, itemName);
        } // if itemId == current.itemId, do nothing (no duplicates)

        return current;
    }


    /**
     * Returns true if an item with the given ID exists, otherwise false.
     * @param itemId
     * @return 
     */
    boolean hasItem(int itemId) {

        return hasItemRecursive(root, itemId);
    }

    private boolean hasItemRecursive(Node current, int itemId) {
        if (current == null) {
            return false;
        }

        if (itemId == current.itemId) {
            return true;
        } else if (itemId < current.itemId) {
            return hasItemRecursive(current.left, itemId);
        } else {
            return hasItemRecursive(current.right, itemId);
        }
    }


    /**
     * Returns the item itemName if the ID exists; otherwise returns "Item not found".
     * @param itemId
     * @return
     */
    String getItemitemName(int itemId) {

        return getItemitemNameRecursive(root, itemId);
    }
    private String getItemitemNameRecursive(Node current, int itemId) {
        if (current == null) {
            return "Item not found";
        }

        if (itemId == current.itemId) {
            return current.itemName;
        } else if (itemId < current.itemId) {
            return getItemitemNameRecursive(current.left, itemId);
        } else {
            return getItemitemNameRecursive(current.right, itemId);
        }
    }



    /**
     * Prints all items in ascending order by item ID.
     * Each line should print: Item ID: <id>, itemName: <itemName>
     * 
     */
    void printInventory() {
        printInventoryRecursive(root);
    }
     private void printInventoryRecursive(Node current) {
        if (current != null) {
            printInventoryRecursive(current.left);
            System.out.println("Item ID: " + current.itemId + ", itemName: " + current.itemName);
            printInventoryRecursive(current.right);
        }
    }
}

