/*
 * Insertion is a basic but frequently used operation. Arrays in most languages can not be 
 * dynamically shrinked or expanded. Here, we will work with such arrays and try to insert 
 * an element at the end of the array.
 * You need to modify the given array arr. 
 * The size of the array is given by sizeOfArray. You need to insert an element at the end. 
 * Array already have the sizeofarray -1 elements. Find Kth Rotation
 */

package Arrays.Basics;

public class InsertAtEnd {
    public static void insertAtEnd(int arr[], int sizeOfArray, int element) {     
        arr[sizeOfArray-1] = element;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
       int sizeOfArray = 4;
        int[] arr = new int[sizeOfArray];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        insertAtEnd(arr, sizeOfArray, 99); 
    }
}