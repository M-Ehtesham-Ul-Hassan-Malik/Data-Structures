import java.util.Scanner;

public class q2 {

    public static int binarySearch(int[] arr, int key){
        int start = 0 , end = arr.length-1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (arr[mid] == key){        //found
                return mid;
            }

           else if (arr[mid] < key){
                start = mid+1;
            }

            else {
                end = mid - 1;
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
     //   binarySearch(arr,key);

        System.out.println("Key found at index: "+binarySearch(arr,key));
    }

}
