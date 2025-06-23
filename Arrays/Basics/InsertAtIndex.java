/*
 * Insertion is a basic but frequently used operation. 
 * Arrays in most languages cannnot be dynamically shrinked or expanded. 
 * Here, we will work with such arrays and try to insert an element at some index.
 * You are given an array arr(0-based index). The size of the array is given by sizeOfArray. 
 * You need to insert an element at given index.
 */
package Arrays.Basics;

public class InsertAtIndex {
    public void insertAtIndex(int arr[], int sizeOfArray, int index, int element) {
        // Your code here, Geeks
        for(int i = sizeOfArray-2; i >= index; i--){ // might make mistake here by choosing -1 
            arr[i+1] = arr[i];                       // and has to start from reverse last index will be empty   
        }
        arr[index] = element;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void main(String[] args) {
        InsertAtIndex in = new InsertAtIndex();
       int[] arr = new int[5]; 
       arr[0] = 1;
       arr[1] = 2;
       arr[2] = 3;
       arr[3] = 3;
       in.insertAtIndex(arr, 5, 3, 1);
    }
}
