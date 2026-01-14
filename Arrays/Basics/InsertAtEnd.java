/*
Problem:
Given an array with size sizeOfArray, where only (sizeOfArray - 1) elements
are initially present, insert a given element at the end of the array.

Note:
Arrays in Java have fixed size, so insertion at the end means placing
the element at index (sizeOfArray - 1).

Approach:
- The last index of the array is (sizeOfArray - 1).
- Directly assign the given element to this index.
- Print the array to verify insertion.

Time Complexity:
O(1) for insertion
O(n) for printing the array

Auxiliary Space:
O(1) — insertion is done in the existing array.
*/

package Arrays.Basics;

public class InsertAtEnd {

    public static void insertAtEnd(int arr[], int sizeOfArray, int element) {
        arr[sizeOfArray - 1] = element;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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

/*
Dry Run:

Initial Array:
arr = [1, 2, 3, 0]
sizeOfArray = 4

Step 1:
Insert element 99 at index sizeOfArray - 1
arr[3] = 99

Step 2:
Array becomes:
[1, 2, 3, 99]

Output:
1 2 3 99
*/
