public class Q4 {

    // Function to partition the array based on the pivot element (nut)
    private static int partition(char[] arr, int low, int high, char pivot) {
        int i = low;
        // Move smaller elements to the left of pivot
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            } else if (arr[j] == pivot) {
                swap(arr, j, high);
                j--; // Move back j to recheck the current element after swap
            }
        }
        // Move pivot to its correct position
        swap(arr, i, high);
        return i;
    }

    // Function to match nuts and bolts using recursive partitioning
    public static void matchPairs(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            // Choose a pivot nut from the nuts array
            char pivot = nuts[high];
            // Partition bolts array based on the pivot nut
            int pivotIndex = partition(bolts, low, high, pivot);
            // Partition nuts array based on the corresponding pivot bolt
            partition(nuts, low, high, bolts[pivotIndex]);

            // Recursively match subsets
            matchPairs(nuts, bolts, low, pivotIndex - 1); // Left subset
            matchPairs(nuts, bolts, pivotIndex + 1, high); // Right subset
        }
    }

    // Utility function to swap elements in an array
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        char[] nuts = {'@', '%', '$', '#', '^'};
        char[] bolts = {'%', '@', '#', '$', '^'};
        int n = nuts.length;

        // Match nuts and bolts efficiently
        matchPairs(nuts, bolts, 0, n - 1);

        // Print matched pairs
        System.out.print("Matched pairs: ");
        for (int i = 0; i < n; i++) {
            System.out.print("(" + nuts[i] + ", " + bolts[i] + ") ");
        }
        System.out.println();
    }
}
