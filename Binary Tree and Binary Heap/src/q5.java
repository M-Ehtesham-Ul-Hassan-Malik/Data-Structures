public class q5 {

    public static boolean isMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (arr[i] > arr[2 * i + 1] || (2 * i + 2 < n && arr[i] > arr[2 * i + 2])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (arr[i] < arr[2 * i + 1] || (2 * i + 2 < n && arr[i] < arr[2 * i + 2])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 9, 6, 3, 5, 8};

        if (isMinHeap(arr)) {
            System.out.println("The given tree is a min heap.");
        } else if (isMaxHeap(arr)) {
            System.out.println("The given tree is a max heap.");
        } else {
            System.out.println("The given tree is not a heap.");
        }
    }
}
