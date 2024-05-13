public class q2 {

    public static void quickSortDescending(int[] arr) {
        quickSortDescending(arr, 0, arr.length - 1);
    }

    private static void quickSortDescending(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the subarrays
            quickSortDescending(arr, low, pivotIndex - 1);  // Sort left subarray
            quickSortDescending(arr, pivotIndex + 1, high); // Sort right subarray
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Choose pivot as the first element
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (i <= j) {
            if (arr[i] >= pivot) {
                i++;
            } else if (arr[j] < pivot) {
                j--;
            } else {
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // Swap pivot (arr[low]) with arr[j]
        swap(arr, low, j);

        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};

        System.out.println("Original Array:");
        printArray(arr);

        // Perform quicksort in descending order
        quickSortDescending(arr);

        System.out.println("Sorted Array in Descending Order:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
