public class q1 {

    public static void main(String[] args) {
        int N = 10; // Change N to the desired number of terms
        System.out.println("First " + N + " terms of Fibonacci series in reverse order:");
        printFibonacciReverse(N);
    }

    public static void printFibonacciReverse(int N) {
        for (int i = N - 1; i >= 0; i--) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
