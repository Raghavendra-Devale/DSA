/*
LeetCode Problem 33:
Search in Rotated Sorted Array
https://leetcode.com/problems/search-in-rotated-sorted-array/

Problem:
Given a rotated sorted array nums (with distinct values) and a target value,
return the index of the target if it exists, otherwise return -1.
*/

package Arrays.Medium;

public class SearchInRotatedArray {

    /*
    Approach Used (Two-End Linear Search):

    Idea:
    - Use two pointers:
      - One starting from the left (l)
      - One starting from the right (r)
    - In each iteration:
      - Check if target matches nums[l] or nums[r]
      - If not, move both pointers inward

    Note:
    - This approach does NOT use binary search.
    - It works correctly but does not leverage the sorted + rotated property.

    Time Complexity:
    O(n)

    Auxiliary Space:
    O(1)
    */
    public static int search(int[] nums, int target) {
        int result = -1;
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] == target) {
                return l;
            } else if (nums[r] == target) {
                return r;
            }
            l++;
            r--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}

/*
Dry Run:

Input:
nums = [4, 5, 6, 7, 0, 1, 2]
target = 0

Iteration 1:
l = 0 → nums[0] = 4
r = 6 → nums[6] = 2
No match → l++, r--

Iteration 2:
l = 1 → nums[1] = 5
r = 5 → nums[5] = 1
No match → l++, r--

Iteration 3:
l = 2 → nums[2] = 6
r = 4 → nums[4] = 0 → match found

Return index:
4

Output:
4
*/
