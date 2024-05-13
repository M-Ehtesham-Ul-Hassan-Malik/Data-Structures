import java.util.Scanner;

public class q4 {

    public static boolean binarySearch(int[] arr, int key){
        int start = 0 , end = arr.length-1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (arr[mid] == key){        //found
                return true;
            }

            else if (arr[mid] < key){
                start = mid+1;
            }

            else {
                end = mid - 1;
            }

        }
        return false;       //not found
    }



    public static void main(String[] args) {
        int arr[] = {14,6,18,23,4,67,48,78,3,2,74,76,8};
        int key;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key: ");
        key = sc.nextInt();
        //   binarySearch(arr,key);

        System.out.println(binarySearch(arr,key));
    }

}
