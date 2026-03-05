package Arrays.Medium;

/*
LeetCode 167
Two Sum II - Input Array Is Sorted

Problem:
Given a 1-indexed array of integers numbers that is already sorted
in non-decreasing order, find two numbers such that they add up to
a specific target number.

Return the indices (1-based) of the two numbers.

------------------------------------------------------------

Approach 1: Brute Force

Idea:
- Use two nested loops.
- Check every pair.
- Return indices (1-based) when sum matches target.

Time Complexity: O(n^2)
Space Complexity: O(1)

------------------------------------------------------------

Approach 2: Optimal (Two Pointers)

Idea:
- Since array is sorted:
    - Start one pointer at beginning (left)
    - One pointer at end (right)
- If sum < target → move left++
- If sum > target → move right--
- If equal → return indices (1-based)

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class TwoSum_II {

    // Brute Force
    public static int[] twoSumBrute(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // Optimal Solution (Two Pointers)
    public static int[] twoSumOptimal(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] brute = twoSumBrute(numbers, target);
        int[] optimal = twoSumOptimal(numbers, target);

        System.out.println("Brute: [" + brute[0] + ", " + brute[1] + "]");
        System.out.println("Optimal: [" + optimal[0] + ", " + optimal[1] + "]");
    }
}