/*
LeetCode:
Contains Duplicate II
https://leetcode.com/problems/contains-duplicate-ii/

Problem:
Given an integer array nums and an integer k, return true if there are
two distinct indices i and j such that:
- nums[i] == nums[j]
- |i - j| <= k

Otherwise, return false.
*/

package Arrays.Easy;

import java.util.HashSet;

public class ContainsDuplicateII {

    /*
    Brute Force Approach:

    Approach:
    - Use two nested loops to compare every pair of elements.
    - If duplicate elements are found, calculate the absolute difference
      between their indices.
    - If the index difference is less than or equal to k, return true.

    Time Complexity:
    O(n²) — due to nested loops.

    Auxiliary Space:
    O(1)
    */
    public static boolean bruteContainsNearbyDuplicate(int[] nums, int k) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    n = Math.abs(i - j);
                    if (n <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
    Intended Optimal Approach (HashSet-based):

    Idea:
    - Use a HashSet to keep track of recently seen elements.
    - If a duplicate is found within the allowed distance k, return true.
    - Otherwise, continue scanning the array.

    Expected Time Complexity:
    O(n)

    Expected Auxiliary Space:
    O(k)
    */
    public static boolean optimalContainsNearByDuplicate(int[] nums, int k){
        HashSet hSet = new HashSet<>();
        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            if (hSet.contains(nums[i]) && hSet.size() <= k) {
                n = Math.abs(nums[i] - nums[i + 1]);
            }
            hSet.add(nums[i]);
        }

        if (n <= k) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 1};
        int k = 1;
        System.out.println(bruteContainsNearbyDuplicate(arr, k));
    }
}

/*
Dry Run (Brute Force):

Input:
nums = [1, 0, 1, 1]
k = 1

Step-by-step comparisons:
i = 0, j = 2 → nums[0] == nums[2] → |0 - 2| = 2 > k → ignore
i = 2, j = 3 → nums[2] == nums[3] → |2 - 3| = 1 ≤ k → return true

Output:
true
*/
