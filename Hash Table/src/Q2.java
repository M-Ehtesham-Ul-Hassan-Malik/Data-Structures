public class Q2 {

    public static int countPairs(int[] arr, int N, int K) {
        int pairCount = 0;

        // Iterate through each element as the first element of the pair
        for (int i = 0; i < N - 1; i++) {
            int target = K - arr[i];
            boolean found = false;

            // Check remaining elements for complement
            for (int j = i + 1; j < N; j++) {
                if (arr[j] == target) {
                    pairCount++;
                    found = true;
                }
            }

            // If complement found, add 1 to pairCount
            if (found) {
                pairCount++;
            }
        }

        return pairCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 1};
        int N = arr.length;
        int K = 6;

        int result = countPairs(arr, N, K);
        System.out.println("Number of pairs whose sum is " + K + ": " + result);
    }
}
