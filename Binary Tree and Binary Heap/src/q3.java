import java.util.*;

public class q3 {
    public void Delete(int[] heap, int n, int key) {
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (heap[i] == key) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Element not found in the heap.");
            return;
        }


        heap[index] = heap[n - 1];


        heapify(heap, n - 1, index);
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] heap = {1, 2, 3, 4, 5, 6, 7};
        int keyToDelete = 3;
        int n = heap.length;

        q3 Obj3 = new q3();
        Obj3.Delete(heap, n, keyToDelete);

        System.out.println("Heap after deleting " + keyToDelete + ": " + Arrays.toString(Arrays.copyOf(heap, n - 1)));
    }
}