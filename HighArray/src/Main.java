// This class represents an array of long integers with various methods for manipulating the array
class HighArray {
    private long[] a; // The array of long integers
    private int nElems; // The number of elements in the array

    // Constructor that initializes the array with a given maximum size
    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    // Method for inserting a new element into the array
    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    // Method for getting the length of the array
    public int arrLength() {
        return nElems;
    }

    // Method for deleting an element from the array
    public boolean delete(int value) {
        for(int k = value; k<nElems; k++)
            a[k] = a[k+1];
        nElems--;
        return true;
    }

    // Method for finding the index of the minimum element in a given range of the array
    public int getMinIndex(int low,int high){
        int m=0;
        int j = low;
        long ek = a[j];

        if(low > high)
            return -1;
        else if(high >= nElems)
            return -1;
        else {
            for (j = low; j <= high; j++)
                if (a[j] <= ek) {
                    ek = a[j];
                    m = j;
                }
            return m;
        }
    }

    // Method for placing the minimum element in a given range of the array at the beginning of the range
    public boolean placeMin(int low, int high){
        int m;
        m = getMinIndex(low,high);

        if(low > high)
            return false;
        else if(high >= nElems)
            return false;
        else if(low == high)
            return true;
        else {
            for (int k = m - 1; k >= low; k--) {
                int c = (int) a[k];
                a[k] = a[k + 1];
                a[k + 1] = c;
            }
            return true;
        }
    }

    // Method for sorting the array using the placeMin method
    public boolean sort(){
        int m = nElems - 1;
        for(int k=0; k<=m; k++) {
            placeMin(k,m);
        }
        return true;
    }

    // Method for removing duplicate elements from the array
    public boolean removeDublicates(){
        for(int m=0 ; m < nElems ; m++)
            for(int k = m+1 ; k < nElems ; k++) {
                if (a[m] == a[k])
                    a[k] = -1;
            }
        return true;
    }

    // Method for displaying the contents of the array
    public void display() {
        for(int j=0; j<nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    // Method for getting the element at a given index in the array
    public long getElem(int index) {
        return a[index];
    }
}

// This class represents an ordered array and has a method for removing duplicate elements
class OrdArray {
    public void removeDublicates(HighArray target){
        int j;
        int m = target.arrLength();
        for(j=0; j<m; j++)
            if(target.getElem(j) == -1) {
                target.delete(j);
            }
    }
}

// This is the main class that creates instances of HighArray and OrdArray and tests their methods
class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;
        OrdArray OrdArr;

        arr = new HighArray(maxSize);
        OrdArr = new OrdArray();

        // Inserting elements into the array
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(123);
        arr.insert(434);
        arr.insert(854);
        arr.insert(11);
        arr.insert(66);
        arr.insert(123);
        arr.insert(33);
        arr.insert(88);

        // Displaying the contents of the array
        arr.display();
        System.out.println(" ");

        // Testing the getMinIndex method
        System.out.println(arr.getMinIndex(10,5));
        System.out.println(arr.getMinIndex(20,25));
        System.out.println(arr.getMinIndex(5,18));
        System.out.println(arr.getMinIndex(5,11));
        System.out.println(arr.getMinIndex(6,6));
        System.out.println(arr.getMinIndex(0,5));
        System.out.println(" ");

        // Testing the placeMin method
        if(arr.placeMin(3,11))
            arr.display();
        if(arr.placeMin(1,5))
            arr.display();
        if(arr.placeMin(8,15))
            arr.display();
        if(arr.placeMin(12,4))
            arr.display();
        if(arr.placeMin(8,25))
            arr.display();

        System.out.println(" ");

        // Testing the sort method
        if(arr.sort())
            arr.display();

        System.out.println(" ");

        // Testing the removeDublicates method
        if(arr.removeDublicates())
            arr.display();

        System.out.println(" ");

        // Testing the removeDublicates method of the OrdArray class
        OrdArr.removeDublicates(arr);
        arr.display();
    }
}