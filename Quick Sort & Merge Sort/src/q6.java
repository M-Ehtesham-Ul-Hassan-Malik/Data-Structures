import java.util.*;

public class q6 {

    public static int[] mergeKArrays(int[][] arrays) {
        // Min-Heap to store the elements along with their array index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Add the first element from each array into the min-heap
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new int[]{arrays[i][0], i, 0}); // {value, array index, element index}
            }
        }

        List<Integer> mergedList = new ArrayList<>();

        // Process elements from the min-heap
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int value = top[0];
            int arrayIdx = top[1];
            int elementIdx = top[2];

            // Add the smallest element to the merged list
            mergedList.add(value);

            // Move to the next element in the same array (if available)
            if (elementIdx + 1 < arrays[arrayIdx].length) {
                int nextValue = arrays[arrayIdx][elementIdx + 1];
                minHeap.offer(new int[]{nextValue, arrayIdx, elementIdx + 1});
            }
        }

        // Convert List<Integer> to int[]
        int[] mergedArray = new int[mergedList.size()];
        for (int i = 0; i < mergedList.size(); i++) {
            mergedArray[i] = mergedList.get(i);
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[][] arrays1 = {
                {3, 13},
                {8, 10, 11},
                {9, 15}
        };

        int[][] arrays2 = {
                {1, 5},
                {2, 3, 4}
        };

        int[] mergedArray1 = mergeKArrays(arrays1);
        int[] mergedArray2 = mergeKArrays(arrays2);

        System.out.println("Merged Array 1: " + Arrays.toString(mergedArray1));
        System.out.println("Merged Array 2: " + Arrays.toString(mergedArray2));
    }
}
