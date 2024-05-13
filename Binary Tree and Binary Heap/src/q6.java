import java.util.*;

public class q6 {

    public static void minHeapify(int[] arr, int i, int n) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(arr, i, smallest);
            minHeapify(arr, smallest, n);
        }
    }

    public static void buildMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(arr, i, n);
        }
    }

    public static void heapSort(int[] arr) {
        buildMinHeap(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            minHeapify(arr, 0, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 3, 10, 1};
        System.out.println("Original array:");
        printArray(arr1);

        heapSort(arr1);

        System.out.println("Sorted array in decreasing order using min heap:");
        printArray(arr1);

        int[] arr2 = {1, 50, 100, 25};
        System.out.println("\nOriginal array:");
        printArray(arr2);

        heapSort(arr2);

        System.out.println("Sorted array in decreasing order using min heap:");
        printArray(arr2);
    }
}
