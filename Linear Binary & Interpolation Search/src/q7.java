public class q7 {

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
        int[] arr = {2, 3, 4, 6, 12, 18, 36};
        int key = arr[arr.length-1];
        int specialNumber = interpolationSearch(arr,key);

        if (specialNumber != -1) {
            System.out.println("The special number is: " + arr[specialNumber]);
        } else {
            System.out.println("Special number not found in the array.");
        }

    }

}

