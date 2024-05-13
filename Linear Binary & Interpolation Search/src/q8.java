import java.util.Scanner;

public class q8 {

    public static int binarySearch(int[] arr, int target){
        int start = 0, end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (arr[mid] == target){        //found
                return mid;
            } else if (arr[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int interpolationSearch(int arr[], int target){
        int high = arr.length - 1;
        int low = 0;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            int position = low + (int) (((double)(target - arr[low]) / (arr[high] - arr[low])) * (high - low));

            if (arr[position] == target) {
                return position;
            } else if (arr[position] < target) {
                low = position + 1;
            } else {
                high = position - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr= {
                10,  15,  20,  25,  30,  35,  40,  45,  50,  55,
                60,  65,  70,  75,  80,  85,  90,  95,  100, 105,
                110, 115, 120, 125, 130, 135, 140, 145, 150, 155,
                160, 165, 170, 175, 180, 185, 190, 195, 200, 205,
                210, 215, 220, 225, 230, 235, 240, 245, 250, 255,
                260, 265, 270, 275, 280, 285, 290, 295, 300, 305,
                310, 315, 320, 325, 330, 335, 340, 345, 350, 355,
                360, 365, 370, 375, 380, 385, 390, 395, 400, 405,
                410, 415, 420, 425, 430, 435, 440, 445, 450, 455,
                460, 465, 470, 475, 480, 485, 490, 495, 500, 505};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to search: ");
        int target = sc.nextInt();

        int interpolationResult = interpolationSearch(arr,target);
        int binaryResult = binarySearch(arr,target);

        System.out.println("Interpolation Result: "+interpolationResult);
        System.out.println("Binary Result: "+binaryResult);


    }


}
