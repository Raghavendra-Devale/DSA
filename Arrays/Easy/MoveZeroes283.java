/*
LeetCode Problem 283
Move Zeroes
https://leetcode.com/problems/move-zeroes/

Problem:
Given an integer array nums, move all 0's to the end 
while maintaining the relative order of the non-zero elements.

Constraints:
- Modify the array in-place.
- Minimize total operations.
*/

package Arrays.Easy;

public class MoveZeroes283 {

    /*
    ============================================================
     Approach 1: Brute Force (Using Extra Array)

    Idea:
    - Create a temporary array.
    - Copy all non-zero elements first.
    - Remaining positions stay 0 by default.
    - Copy temp array back to original.

    Time Complexity: O(n)
    Space Complexity: O(n)
    ============================================================
    */
    public static void moveZeroesBrute(int[] nums) {

        int[] temp = new int[nums.length];
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp[j++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }


    /*
    ============================================================
     Approach 2: Swap-Based (In-Place)

    Idea:
    - Use two pointers.
    - When a non-zero is found, swap with index j.
    - Maintains order but may perform unnecessary swaps.

    Time Complexity: O(n)
    Space Complexity: O(1)
    ============================================================
    */
    public static void moveZeroesSwap(int[] nums) {

        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }


    /*
    ============================================================
     Approach 3: Optimal (Overwrite Method)

    Idea:
    1) Move all non-zero elements forward.
    2) Fill remaining positions with zero.

    This avoids unnecessary swaps.

    Time Complexity: O(n)
    Space Complexity: O(1)
    ============================================================
    */
    public static void moveZeroesOptimal(int[] nums) {

        int j = 0;

        // Move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        // Fill remaining positions with zero
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }


        public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};

        moveZeroesOptimal(arr);

        System.out.print("Modified Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}