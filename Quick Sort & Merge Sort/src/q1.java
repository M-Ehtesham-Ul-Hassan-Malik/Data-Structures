public class q1 {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively apply quickSort to the left and right partitions
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        // Choose the middle element as the pivot
        int pivot = arr[(low + high) / 2];

        // Initialize pointers for partitioning
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // Find element on the left side that is >= pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // Find element on the right side that is <= pivot
            do {
                j--;
            } while (arr[j] > pivot);

            // If the pointers cross, the partition is complete
            if (i >= j) {
                return j;
            }

            // Swap elements at i and j
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {19, 9, 14, 24, 29, 27};

        System.out.println("Original Array:");
        printArray(arr);

        // Sort the array using Quick Sort
        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
