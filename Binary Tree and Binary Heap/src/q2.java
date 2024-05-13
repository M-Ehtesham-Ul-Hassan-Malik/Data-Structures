public class q2  {
    public void Heapify(int[] Arr, int n, int i) {
        int Largest = i;
        int Left = 2 * i + 1;
        int Right = 2 * i + 2;

        if (Left < n && Arr[Left] > Arr[Largest]) {
            Largest = Left;
        }

        if (Right < n && Arr[Right] > Arr[Largest]) {
            Largest = Right;
        }

        if (Largest != i) {
            int Temp = Arr[i];
            Arr[i] = Arr[Largest];
            Arr[Largest] = Temp;
            Heapify(Arr, n, Largest);
        }
    }

    public void CreateMaxHeap(int[] Arr) {
        int n = Arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            Heapify(Arr, n, i);
        }
    }

    public static void main(String[] args) {
        int[] Arr2 = {12, 11, 13, 5, 6, 7};
        q2 Obj = new q2();
        Obj.CreateMaxHeap(Arr2);
        System.out.print("Max Heap: ");
        for (int num : Arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}