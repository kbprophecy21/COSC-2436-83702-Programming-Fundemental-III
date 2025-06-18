import java.util.Scanner;

public class Problem2 {

    // Recursive method to calculate edit distance
    public static int editDistance(String str1, String str2) {
        // Base Cases
        if (str1.length() == 0) {
            return str2.length(); // need to insert all of str2
        }
        if (str2.length() == 0) {
            return str1.length(); // need to delete all of str1
        }

        // If first characters match, skip them
        if (str1.charAt(0) == str2.charAt(0)) {
            return editDistance(str1.substring(1), str2.substring(1));
        }

        // Otherwise try insert, delete, and replace
        int insertOp = 1 + editDistance(str1, str2.substring(1));
        int deleteOp = 1 + editDistance(str1.substring(1), str2);
        int replaceOp = 1 + editDistance(str1.substring(1), str2.substring(1));

        // Return the minimum of the three operations
        return Math.min(insertOp, Math.min(deleteOp, replaceOp));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String first = scanner.nextLine();
        System.out.print("Enter second string: ");
        String second = scanner.nextLine();

        int distance = editDistance(first, second);
        System.out.println("Edit distance: " + distance);
    }
}
