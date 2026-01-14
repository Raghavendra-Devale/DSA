/*
Problem:
Given a fixed-size array (0-based index) with size sizeOfArray,
insert an element at a given index.

Important Note:
Since arrays cannot be resized, the last position is assumed to be empty.
To insert at a given index, elements must be shifted one position to the right.

Approach:
1) Start shifting elements from the second last index (sizeOfArray - 2).
2) Move elements one step to the right until the target index is reached.
3) Insert the given element at the specified index.
4) Print the updated array.

Why shifting from right to left?
- Shifting forward would overwrite values.
- Shifting backward preserves existing elements.

Time Complexity:
O(n) — due to element shifting.

Auxiliary Space:
O(1) — insertion is done in-place.
*/

package Arrays.Basics;

public class InsertAtIndex {

    public void insertAtIndex(int arr[], int sizeOfArray, int index, int element) {
        for(int i = sizeOfArray - 2; i >= index; i--){
            arr[i + 1] = arr[i];
        }
        arr[index] = element;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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

/*
Dry Run:

Initial Array:
arr = [1, 2, 3, 3, 0]
sizeOfArray = 5
index = 3
element = 1

Step 1: Shift elements to the right
i = 3 → arr[4] = arr[3] → [1, 2, 3, 3, 3]
i = 2 → arr[3] = arr[2] → [1, 2, 3, 3, 3]

Step 2: Insert element
arr[3] = 1

Final Array:
[1, 2, 3, 1, 3]

Output:
1 2 3 1 3
*/
