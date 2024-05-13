public class q5 {

    public static int linearSearch(int arr[]){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int  binarySearch(int arr[]){
        int start = 0;
        int end = arr.length-1;


        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == arr[end]) {
                // Handle duplicate values
                end--;
            } else if (arr[mid] < arr[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return arr[start];
    }



    public static void main(String[] args) {
        int arr[] = {11, 22, 33, 44, 55};
        int max = linearSearch(arr);
        int min = binarySearch(arr);

        System.out.println("Max is: "+ linearSearch(arr));
        System.out.println("Min is: "+ min);
    }

}
