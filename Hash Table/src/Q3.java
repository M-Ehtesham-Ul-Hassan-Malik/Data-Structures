public class Q3 {

    public static int findTriplet(int[] arr, int n) {
        // Iterate through each element as the potential first element of the triplet
        for (int i = 0; i < n - 2; i++) {
            // Use a hashmap to store the complement of the pair (arr[j], arr[k])
            // where arr[j] + arr[k] = -arr[i]
            boolean found = false;
            for (int j = i + 1; j < n - 1; j++) {
                int complement = -arr[i] - arr[j];
                boolean isDuplicate = false;

                // Check if complement already exists in the remaining part of the array
                for (int k = j + 1; k < n; k++) {
                    if (arr[k] == complement && !isDuplicate) {
                        found = true;
                        isDuplicate = true; // Mark as a duplicate to avoid counting multiple times
                    }
                }
            }

            if (found) {
                return 1; // Found a triplet that sums to zero
            }
        }

        return 0; // No valid triplet found
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        int n = arr.length;

        int result = findTriplet(arr, n);
        System.out.println("Output: " + result);
    }
}
