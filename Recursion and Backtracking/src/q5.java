import java.util.*;

public class q5 {

    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "XY";

        System.out.println("Permutations of " + s1 + ": ");
        printPermutations(s1);

        System.out.println("\nPermutations of " + s2 + ": ");
        printPermutations(s2);
    }

    public static void printPermutations(String str) {
        printPermutationsHelper("", str);
    }

    private static void printPermutationsHelper(String prefix, String remaining) {
        int n = remaining.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                printPermutationsHelper(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1, n));
            }
        }
    }
}
