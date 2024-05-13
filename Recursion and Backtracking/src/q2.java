public class q2 {

    public static void main(String[] args) {
        int num1 = 12345;
        int num2 = 45632;

        System.out.println("Sum of digits of " + num1 + ": " + sumOfDigits(num1));
        System.out.println("Sum of digits of " + num2 + ": " + sumOfDigits(num2));
    }

    public static int sumOfDigits(int num) {
        // Base case: if the number is a single digit, return the number itself
        if (num < 10)
            return num;
            // Recursive case: sum the last digit with the sum of digits of the remaining number
        else
            return num % 10 + sumOfDigits(num / 10);
    }
}
