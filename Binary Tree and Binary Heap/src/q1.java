public class q1  {
    public int[] Arr1;
    public int Size;

    public q1(int Capacity) {
        Arr1 = new int[Capacity];
        Size = 0;
    }

    public void Insert(int Value) {
        if (Size == Arr1.length) {
            System.out.println("Tree is full. Cannot Insert more nodes.");
            return;
        }
        Arr1[Size] = Value;
        Size++;
    }


    public void Delete(int Index) {
        if (Index < 0 || Index >= Size) {
            System.out.println("Invalid Index.");
            return;
        }

        Arr1[Index] = Arr1[Size - 1];
        Size--;
    }

    public int CountParent() {
        return Size / 2;
    }
    public int CountLeaf() {
        return (Size + 1) / 2;
    }
    public int CountEven() {
        int Count = 0;
        for (int i = 0; i < Size; i++) {
            if (Arr1[i] % 2 == 0) {
                Count++;
            }
        }
        return Count;
    }

    public static void main(String[] args) {
        q1 Obj1 = new q1(10);
        Obj1.Insert(10);
        Obj1.Insert(20);
        Obj1.Insert(30);
        Obj1.Insert(65);
        Obj1.Insert(40);
        Obj1.Insert(79);
        Obj1.Insert(50);

        System.out.println("Parent Nodes: " + Obj1.CountParent());
        System.out.println("Leaf Nodes: " + Obj1.CountLeaf());
        System.out.println("Even Nodes: " + Obj1.CountEven());

        Obj1.Delete(1);

        System.out.println("Parent Nodes after deletion: " + Obj1.CountParent());
        System.out.println("Leaf Nodes after deletion: " + Obj1.CountLeaf());
        System.out.println("Even Nodes after deletion: " + Obj1.CountEven());
    }
}