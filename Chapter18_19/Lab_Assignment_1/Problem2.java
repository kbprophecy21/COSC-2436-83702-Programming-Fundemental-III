

public class Problem2 {

    
    public static int editDistance(String word_Number_1, String word_Number_2) {

       
        if (word_Number_1.length() == 0) {
            return word_Number_2.length(); 
        }
        if (word_Number_2.length() == 0) {
            return word_Number_1.length(); 
        }

        
        if (word_Number_1.charAt(0) == word_Number_2.charAt(0)) {
            return editDistance(word_Number_1.substring(1), word_Number_2.substring(1));
        }

        // Otherwise try insert, delete, and replace
        int NumberOfInserts = 1 + editDistance(word_Number_1, word_Number_2.substring(1));
        int NumberOfDeletes = 1 + editDistance(word_Number_1.substring(1), word_Number_2);
        int NumberOfReplacement = 1 + editDistance(word_Number_1.substring(1), word_Number_2.substring(1));

        // Return the minimum of the three operations
        return Math.min(NumberOfInserts, Math.min(NumberOfDeletes, NumberOfReplacement));
    }

    public static void main(String[] args) {
       
        int amountOfChanges = editDistance("kitten", "sitting");
        System.out.println("Number of changes from kitten to sitting: " + amountOfChanges);

        amountOfChanges = editDistance("flaw", "lawn");
        System.out.println("Number of changes from for flaw to lawn: " + amountOfChanges);

        amountOfChanges = editDistance("intention", "execution");
        System.out.println("Number of changes from for intention to execution: " + amountOfChanges);
    }
}
