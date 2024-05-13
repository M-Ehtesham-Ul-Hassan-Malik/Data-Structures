public class q6 {
    public static int linearSearch(int arr[], int key,int [] count){
        int lastOccurance = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==key){
                lastOccurance =i;
                count[0]++;
            }
        }
        return lastOccurance;
    }


    public static void main(String[] args) {
        int arr[] = {14,6,4,18,23,4,67,48,78,4,3,2,74,76,8};
        int key = 4;
        int count [] = {0};

        int result = linearSearch(arr,key,count);
        if (result!=-1){
            System.out.println("The last time "+key+" occur at index: "+result);
            System.out.println("total count: "+count[0]);
        }
        else {
            System.out.println(" "+key+" not found in the given array.");
        }

    }
}
