
public class Problem1 {

    public static int sumOfDigit(int number) {
        if (number == 0) {
            return 0;
        }
            
        return number % 10 + sumOfDigit(number / 10);
    }

    public static void main(String[] args) {
        
        System.out.println(sumOfDigit(456));
        System.out.println(sumOfDigit(123));
        System.out.println(sumOfDigit(782453));

    }
}