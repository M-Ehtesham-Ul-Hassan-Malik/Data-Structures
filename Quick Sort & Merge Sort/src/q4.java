import java.util.Arrays;

public class q4{

    public static int maximumToys(int[] arr, int N, int K) {
        // Sort the array using quick sort
        quickSort(arr, 0, N - 1);

        int count = 0;
        int currentSum = 0;

        // Iterate through the sorted array and buy toys until budget is exhausted
        for (int i = 0; i < N; i++) {
            if (currentSum + arr[i] <= K) {
                currentSum += arr[i];
                count++;
            } else {
                break; // Stop buying further toys if budget is exceeded
            }
        }

        return count;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 12, 5, 111, 200, 1000, 10};
        int N = arr.length;
        int K = 50;

        System.out.println("Toy Costs: " + Arrays.toString(arr));
        System.out.println("Maximum number of toys you can buy: " + maximumToys(arr, N, K));
    }
}
