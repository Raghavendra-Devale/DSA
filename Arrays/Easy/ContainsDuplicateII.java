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
import java.util.Set;

public class ContainsDuplicateII {

    /*
    ------------------------------------------------------------
    Brute Force Approach

    Approach:
    - Use two nested loops to compare every pair of elements.
    - If duplicate elements are found, calculate the absolute
      difference between their indices.
    - If |i - j| <= k, return true.

    Time Complexity:
    O(n^2)

    Auxiliary Space:
    O(1)
    ------------------------------------------------------------
    */
    public static boolean bruteContainsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {

                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    /*
    ------------------------------------------------------------
    Optimal Approach (Sliding Window + HashSet)

    Idea:
    - Use a HashSet to maintain a window of size k.
    - The set stores at most k recent elements.
    - If current element already exists in the set,
      it means duplicate within range k.
    - If window size exceeds k, remove the element
      that falls out of range (nums[i - k]).

    Time Complexity:
    O(n)

    Auxiliary Space:
    O(k)
    ------------------------------------------------------------
    */
    public static boolean optimalContainsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // If duplicate found inside current window
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            // Maintain window size of k
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }


    public static void main(String[] args) {

        int[] arr = {1, 0, 1, 1};
        int k = 1;

        System.out.println("Brute: " + bruteContainsNearbyDuplicate(arr, k));
        System.out.println("Optimal: " + optimalContainsNearbyDuplicate(arr, k));
    }
}


/*
Dry Run Example:

Input:
nums = [1, 0, 1, 1]
k = 1

Brute Force:
i = 2, j = 3 → nums[2] == nums[3]
|2 - 3| = 1 <= k → return true

Optimal:
i = 0 → set = {1}
i = 1 → set = {1, 0}, remove 1 → set = {0}
i = 2 → set = {0, 1}, remove 0 → set = {1}
i = 3 → 1 already in set → return true
*/