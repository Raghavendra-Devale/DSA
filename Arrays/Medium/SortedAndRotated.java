/*
Problem:
Given an array of N distinct integers, check whether the array is
sorted (either non-decreasing or non-increasing) and rotated
(counter-clockwise).

Important Notes:
- The array can be originally sorted in ascending or descending order.
- A purely sorted array (with no rotation) is NOT considered valid.
- There must be at least one rotation.

Example:
Input: {3, 4, 1, 2}
Output: Yes
Explanation: Sorted array {1, 2, 3, 4} rotated twice.
*/

package Arrays.Medium;

/*
Approach Used (Break Counting):

Key Idea:
- A sorted and rotated array must have exactly ONE "break" in ordering.
- A break means the order changes when moving from one element to the next.

Types of breaks:
1) Ascending break:
   When an ascending order array breaks at rotation point.
   Example: {1, 2, 3, 4, 1}

2) Descending break:
   When a descending order array breaks at rotation point.
   Example: {5, 4, 3, 2, 6}

Logic:
- Count how many times ascending order breaks.
- Count how many times descending order breaks.
- Also check the circular edge case between last and first element.
- Valid if exactly one break exists (ascending OR descending),
  and the array is not purely sorted.
*/

public class SortedAndRotated {

    public static boolean checkRotatedAndSorted(int arr[], int num) {

        int ascBreak = 0;
        int descBreak = 0;

        // Traverse array to count order breaks
        for (int i = 0; i < arr.length - 1; i++) {

            // Checking for order changes
            if (arr[i] > arr[i + 1]) {
                ascBreak++;
            }

            if (arr[i] < arr[i + 1]) {
                descBreak++;
            }
        }

        // Circular edge case checks
        if (arr[num - 1] > arr[0]) {
            ascBreak++;
        }

        if (arr[num - 1] < arr[0]) {
            descBreak++;
        }

        // Valid if exactly one break exists
        if (ascBreak == 1 || descBreak == 1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 1, 2, 5};
        System.out.println(checkRotatedAndSorted(arr, arr.length));
    }
}

/*
Dry Run:

Input:
arr = {3, 4, 1, 2, 5}

Step-by-step:
Comparisons:
3 < 4 → descending break++
4 > 1 → ascending break++
1 < 2 → descending break++
2 < 5 → descending break++

Edge check:
last = 5, first = 3
5 > 3 → ascending break++

ascBreak = 2
descBreak = 3

Result:
More than one break → NOT sorted and rotated

Output:
false
*/
