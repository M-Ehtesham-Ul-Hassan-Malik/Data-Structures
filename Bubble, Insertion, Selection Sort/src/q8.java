import java.util.Random;

public class q8 {

    // Generate an array of random integers
    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000); // Adjust the range as needed
        }
        return arr;
    }

    // Bubble sort algorithm
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Print array elements
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // Create an array of 50 random integers
        int[] randomArray50 = generateRandomArray(50);
        System.out.println("Original array (50 elements):");
        printArray(randomArray50);

        // Apply bubble sort to the 50-element array
        bubbleSort(randomArray50);
        System.out.println("\nSorted array (50 elements):");
        printArray(randomArray50);

        // Create a new array of 100 random integers
        int[] randomArray100 = generateRandomArray(100);

        // Apply bubble sort to the 100-element array
        bubbleSort(randomArray100);
        System.out.println("\nSorted array (100 elements):");
        printArray(randomArray100);
    }


}
