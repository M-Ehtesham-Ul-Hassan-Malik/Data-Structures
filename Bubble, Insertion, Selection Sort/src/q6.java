public class q6 {

    public static void main(String[] args) {
        int arr[] = {197,98,101,189,90,202};

        // Bubble Sort
        int bubbleSortedArray[] = bubbleSort(arr.clone());
        System.out.println("Bubble Sort:");
        printArray(bubbleSortedArray);

        // Selection Sort
        int selectionSortedArray[] = selectionSort(arr.clone());
        System.out.println("Selection Sort:");
        printArray(selectionSortedArray);

        // Insertion Sort
        int insertionSortedArray[] = insertionSort(arr.clone());
        System.out.println("Insertion Sort:");
        printArray(selectionSortedArray);
}

    public static int[] bubbleSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    public static int[] selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[smallest]) {
                    smallest = j;
                }
            }

            // Swap elements
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static int[] insertionSort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i > n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move larger elements to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        return arr;
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
