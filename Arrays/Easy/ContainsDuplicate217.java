package Arrays.Easy;

import java.util.HashSet;
import java.util.Set;

/*
LeetCode 217
Contains Duplicate

Problem:
Given an integer array nums, return true if any value appears
at least twice in the array, and return false if every element is distinct.

------------------------------------------------------------

Approach 1: Brute Force

Idea:
- Compare every pair using nested loops.
- If duplicate found → return true.

Time Complexity: O(n^2)
Space Complexity: O(1)

------------------------------------------------------------

Approach 2: Optimal (HashSet)

Idea:
- Use a HashSet to track seen elements.
- If an element already exists in the set → duplicate found.
- Otherwise add it to the set.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class ContainsDuplicate217 {

    //  Brute Force
    public static boolean containsDuplicateBrute(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    //  Optimal Solution
    public static boolean containsDuplicateOptimal(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {

            // add() returns false if element already exists
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }

    
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        System.out.println("Brute: " + containsDuplicateBrute(nums));
        System.out.println("Optimal: " + containsDuplicateOptimal(nums));
    }
}