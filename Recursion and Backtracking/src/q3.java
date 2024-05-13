public class q3 {

    public static void main(String[] args) {
        int n = 30;
        System.out.println("Sum of first " + n + " natural numbers: " + sumOfFirstNNumbers(n));
    }

    public static int sumOfFirstNNumbers(int n) {
        // Base case: if n is 0, return 0
        if (n == 0)
            return 0;
            // Recursive case: sum the current number with the sum of the first (n-1) numbers
        else
            return n + sumOfFirstNNumbers(n - 1);
    }
}
