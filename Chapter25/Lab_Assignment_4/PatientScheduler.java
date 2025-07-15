package Chapter25.Lab_Assignment_4;


public class PatientScheduler {

  private class Node {
        int priority;
        String name;
        Node left, right;
        int height;

        Node(int priority, String name) {
            this.priority = priority;
            this.name = name;
            this.height = 1;
        }
    }

    private Node root;
    

    /**
     * Class PatientScheduler using an AVL Tree. I used the private methdods to help me with the AVL Tree.
     * which would keep the methods public but the inner workings private. I felt good about this one. but very stressful.
     */
    // -----------------------------Methods--------------------------------- //

    /**
     * Adds a new patient to the schedule.
     * Patient priorities are unique. Ignore duplicates.
     * * @param priority The priority of the patient (lower number means higher priority).
     * @param name The name of the patient.
     */
    void addPatient(int priority, String name) {
        root = insert(root, priority, name);
    }

    private Node insert(Node node, int priority, String name) {
        if (node == null) return new Node(priority, name);

        if (priority < node.priority)
            node.left = insert(node.left, priority, name);
        else if (priority > node.priority)
            node.right = insert(node.right, priority, name);
        else
            return node; // Duplicate, ignore

        updateHeight(node);
        return balance(node);
    }



    /**
     * Removes a patient with the given priority if they exist.
     * @param priority The priority of the patient to remove.
     */
    void removePatient(int priority) {
        root = delete(root, priority);
    }

   private Node delete(Node node, int priority) {
        if (node == null) return null;

        if (priority < node.priority) {
            node.left = delete(node.left, priority);
        } else if (priority > node.priority) {
            node.right = delete(node.right, priority);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                Node minNode = findMin(node.right);
                node.priority = minNode.priority;
                node.name = minNode.name;
                node.right = delete(node.right, minNode.priority);
            }
        }

        if (node == null) return null;

        updateHeight(node);
        return balance(node);
    }

    /**
     * Returns the name of the patient with the lowest priority number (highest urgency).
     * Return "No patients" if the tree is empty.
     */
    String getHighestPriorityPatient() {
         if (root == null) return "No patients";
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.name;
    }


    /**
     * Prints all patients in ascending order of priority.
     * Format: Priority: <priority>, Name: <name> (one per line)
     */
    void printSchedule() {
        inOrderPrint(root);
    }

    // -----------------------------Helper Methods--------------------------------- //
    // -----Also this showing the AVL Tree that i need for this assignment 
    // borrowed some of this from the Books, I couldn't figure it all out. this was very complicated for me.-----//
    private void inOrderPrint(Node node) {
        if (node != null) {
            inOrderPrint(node.left);
            System.out.println("Priority: " + node.priority + ", Name: " + node.name);
            inOrderPrint(node.right);
        }
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private Node balance(Node node) {
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.left) < 0)
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1) {
            if (getBalance(node.right) > 0)
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

}