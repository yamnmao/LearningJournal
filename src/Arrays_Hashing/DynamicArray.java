package Arrays_Hashing;

class DynamicArray {

    /**DynamicArray(int capacity) will initialize an empty array with a capacity of capacity,
     where capacity > 0.*/
    private int[] arr;
    private int length;
    private int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.arr= new int [this.capacity];

    }

    //int get(int i) will return the element at index i. Assume that index i is valid.
    public int get(int i) {
        return arr[i];
    }

    //void set(int i, int n) will set the element at index i to n. Assume that index i is valid.
    public void set(int i, int n) {
        arr[i]=n;
    }

    //void pushback(int n) will push the element n to the end of the array.
    public void pushback(int n) {
        if(length==capacity){
            resize();
        }
        arr[length]=n;
        length++;
    }

    //int popback() will pop and return the element at the end of the array. Assume that the array is non-empty.
    public int popback() {
        if(length>0){
            length--;
        }
        return arr[length];
    }
    //void resize() will double the capacity of the array.
    private void resize() {
        capcity *= 2;
        int[] newArr = new int[capacity];
        for(int i = 0; i< length; i++)

    }
    //int getSize() will return the number of elements in the array.
    public int getSize() {
        return length;
    }

    //int getCapacity() will return the capacity of the array.
    public int getCapacity() {
        return capacity;
    }
}

