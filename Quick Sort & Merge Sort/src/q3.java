public class q3 {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // No need to sort
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2; // Calculate middle index

            // Recursively sort the left and right halves
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            // Merge the sorted halves
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        // Create temporary arrays for left and right halves
        int[] leftArray = new int[mid - low + 1];
        int[] rightArray = new int[high - mid];

        // Copy data to temporary arrays
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[low + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }

        // Merge the two sorted arrays
        int i = 0, j = 0, k = low;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray (if any)
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray (if any)
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4, 9, 0};

        System.out.println("Original Array:");
        printArray(arr);

        // Perform merge sort
        mergeSort(arr);

        System.out.println("Sorted Array using Merge Sort:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
