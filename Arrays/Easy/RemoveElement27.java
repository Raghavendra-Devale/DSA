/*
LeetCode Problem 27
Remove Element
https://leetcode.com/problems/remove-element/

Problem:
Given an integer array nums and an integer val,
remove all occurrences of val in-place.
Return the number of elements not equal to val.

Constraints:
- Modify the array in-place.
- Extra space is not allowed.
- Order of elements may change.
*/

package Arrays.Easy;

public class RemoveElement27 {

    /*
    ============================================================
     Approach 1: Brute Force (Shifting Method)

    Idea:
    - Traverse the array.
    - If nums[i] == val:
        • Shift all elements to the left.
        • Reduce effective size (n--).
        • Recheck same index (i--).

    Time Complexity: O(n^2)
    Space Complexity: O(1)
    ============================================================
    */
    public static int removeElementBrute(int[] nums, int val) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == val) {

                // Shift elements left
                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }

                n--;   // Reduce size once per removal
                i--;   // Recheck current index
            }
        }

        return n;
    }


    /*
    ============================================================
     Approach 2: Optimal (Two Pointers - Overwrite Method)

    Idea:
    - j scans the array.
    - i stores position for valid elements.
    - If nums[j] != val:
        • Copy nums[j] to nums[i]
        • Increment i

    Time Complexity: O(n)
    Space Complexity: O(1)
    ============================================================
    */
    public static int removeElementOptimal(int[] nums, int val) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }


    /*
    ============================================================
     Approach 3: Swap With Last (When Order Doesn't Matter)

    Idea:
    - If nums[i] == val:
        • Replace it with last element.
        • Reduce size.
    - Do NOT increment i immediately,
      because swapped value must be checked.

    Time Complexity: O(n)
    Space Complexity: O(1)
    ============================================================
    */
    public static int removeElementSwap(int[] nums, int val) {

        int i = 0;
        int n = nums.length;

        while (i < n) {

            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }

        return n;
    }


    /*
    ============================================================
    Common Mistakes I did

    | Mistake | Why It Was Wrong | Fix |
    |----------|-----------------|-----|
    | Updating n inside inner loop | Size reduced multiple times | Reduce once per removal |
    | Decrementing i inside shift loop | Skipped or corrupted indices | Move i-- outside shift loop |
    | Incorrect loop boundaries | Skipped last elements | Use correct n-based conditions |
    | Mixing removal & shifting logic | Hard to reason about correctness | Separate responsibilities clearly |
    ============================================================
    */


 
    public static void main(String[] args) {

        int[] arr = {3, 2, 2, 3};
        int val = 3;

        int result = removeElementOptimal(arr, val);

        System.out.println("New Length: " + result);
        System.out.print("Modified Array: ");

        for (int i = 0; i < result; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}