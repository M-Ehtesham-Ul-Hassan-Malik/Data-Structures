import java.util.Scanner;

public class q3 {

    public static int binarySearch(int[] arr, int key){
        int start = 0, end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (arr[mid] == key){        //found
                return mid;
            } else if (arr[mid] < key){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int interpolationSearch(int arr[], int key){
        int high = arr.length - 1;
        int low = 0;

        while (low <= high && key >= arr[low] && key <= arr[high]) {
            int position = low + (int) (((double)(key - arr[low]) / (arr[high] - arr[low])) * (high - low));

            if (arr[position] == key) {
                return position;
            } else if (arr[position] < key) {
                low = position + 1;
            } else {
                high = position - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {11, 22, 33, 44, 55};
        int key;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key: ");
        key = sc.nextInt();

        int binarySearchResult = binarySearch(arr, key);
        int interpolationSearchResult = interpolationSearch(arr, key);

        if (binarySearchResult != -1) {
            System.out.println("Key found at index by binary search: " + binarySearchResult);
        } else {
            System.out.println("Key not found by binary search.");
        }

        if (interpolationSearchResult != -1) {
            System.out.println("Key found at index by interpolation search: " + interpolationSearchResult);
        } else {
            System.out.println("Key not found by interpolation search.");
        }
    }
}
