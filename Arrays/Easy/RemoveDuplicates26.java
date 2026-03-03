/*
LeetCode Problem 26
Remove Duplicates from Sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Problem:
Given a sorted array nums, remove the duplicates in-place such that
each unique element appears only once.
Return the number of unique elements.

Constraints:
- The array is sorted.
- Must modify the array in-place.
- Extra space is not allowed.
*/

package Arrays.Easy;

public class RemoveDuplicates26 {

    /*
    ------------------------------------------------------------
    Brute Force Approach (Shifting Method)

    Idea:
    - Since the array is sorted, duplicates are adjacent.
    - When nums[i] == nums[i + 1]:
        • Shift all elements to the left.
        • Reduce effective size.
        • Recheck the same index.

    Time Complexity:
    O(n^2)

    Auxiliary Space:
    O(1)
    ------------------------------------------------------------
    */
    public static int removeDuplicatesBrute(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {

            if (nums[i] == nums[i + 1]) {

                // Shift elements left
                for (int j = i + 1; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }

                n--;   // Reduce effective size
                i--;   // Recheck current index
            }
        }

        return n;
    }


    /*
    ------------------------------------------------------------
    Optimal Approach (Two Pointers)

    Idea:
    - Use two pointers:
        i → points to last unique element
        j → scans the array
    - If nums[j] != nums[i]:
        • Move i forward
        • Copy nums[j] to nums[i]

    Time Complexity:
    O(n)

    Auxiliary Space:
    O(1)
    ------------------------------------------------------------
    */
    public static int removeDuplicatesOptimal(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }


   
    public static void main(String[] args) {

        int[] arr1 = {1, 1, 2, 2, 3};
        int[] arr2 = {1, 1, 2, 2, 3};

        int bruteResult = removeDuplicatesBrute(arr1);
        int optimalResult = removeDuplicatesOptimal(arr2);

        System.out.println("Brute Unique Count: " + bruteResult);
        System.out.println("Optimal Unique Count: " + optimalResult);

        System.out.print("Modified Array (Optimal): ");
        for (int i = 0; i < optimalResult; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}