/*
LeetCode Problem 26:
Remove Duplicates from Sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Problem:
Given a sorted array nums, remove the duplicates in-place such that
each unique element appears only once.
Return the number of unique elements.

Constraints:
- The array is sorted.
- Extra space is not allowed.
*/

package Arrays.Easy;

public class RemoveDuplicates26 {

    /*
    Approach (Two Pointers):

    Idea:
    - Use two pointers i and j.
    - Pointer i keeps track of the index of the last unique element.
    - Pointer j scans the array from left to right.

    Steps:
    1) Initialize i = 0 (first element is always unique).
    2) Start j from index 1.
    3) If arr[i] != arr[j]:
       - Increment i
       - Copy arr[j] to arr[i]
    4) After traversal, i + 1 gives the count of unique elements.

    Time Complexity:
    O(n)

    Auxiliary Space:
    O(1)
    */
    public static int ContainsDuplicate(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(ContainsDuplicate(new int[]{1, 1, 1, 1, 1, 1}));
    }
}

/*
Dry Run:

Input:
arr = [1, 1, 1, 1, 1, 1]

Initial:
i = 0

j = 1 → arr[0] == arr[1] → skip
j = 2 → arr[0] == arr[2] → skip
j = 3 → arr[0] == arr[3] → skip
j = 4 → arr[0] == arr[4] → skip
j = 5 → arr[0] == arr[5] → skip

Final i = 0

Unique elements count:
i + 1 = 1

Array after operation:
[1, _, _, _, _, _]

Output:
1
*/
