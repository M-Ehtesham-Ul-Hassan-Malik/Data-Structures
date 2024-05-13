public class q3 {

    public static void main(String[] args) {
        int arr[] = {63, 21, 10, 33, 45, 93, 19};

        sort(arr);

        print_array(arr);
    }

    public static void sort(int arr[]) {

        //insertion sort
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move larger elements to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void print_array(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
