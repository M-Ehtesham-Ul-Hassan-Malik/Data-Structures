public class q4 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 3, 2, 1};

        System.out.println("Is arr1 sorted? " + isSorted(arr1, arr1.length));
        System.out.println("Is arr2 sorted? " + isSorted(arr2, arr2.length));
    }

    public static boolean isSorted(int[] arr, int n) {
        // Base case: if the array has 0 or 1 element, it's considered sorted
        if (n == 0 || n == 1)
            return true;
            // Recursive case: check if the last element is greater than or equal to the second last element
            // and call the function again with the array excluding the last element
        else
            return (arr[n - 1] >= arr[n - 2]) && isSorted(arr, n - 1);
    }
}
