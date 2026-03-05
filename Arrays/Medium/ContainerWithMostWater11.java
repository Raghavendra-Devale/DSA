/*
LeetCode Problem 11:
Container With Most Water
https://leetcode.com/problems/container-with-most-water/

Problem:
You are given an array height where each element represents the height of a vertical line.
Two lines together with the x-axis form a container that can hold water.

The amount of water a container can hold is determined by:

area = min(height[left], height[right]) × (right - left)

Why min(height[left], height[right])?
Water cannot exceed the height of the shorter wall because it would spill over.
*/

package Arrays.Medium;

public class ContainerWithMostWater11 {

    /*
     * Approach 1: Brute Force
     * 
     * Idea:
     * - Check every possible pair of lines.
     * - For each pair, compute the container area.
     * - Keep track of the maximum area found.
     * 
     * Algorithm:
     * - For every index i
     * - For every index j > i
     * - width = j - i
     * - height = min(height[i], height[j])
     * - area = width × height
     * - update maxArea
     * 
     * Time Complexity:
     * O(n²)
     * 
     * Auxiliary Space:
     * O(1)
     * 
     * This works but is inefficient for large inputs because it checks all pairs.
     */

    /*
     * Approach 2: Two Pointers (Optimal)
     * 
     * Idea:
     * - Start with two pointers at the far ends of the array.
     * - This gives the maximum possible width.
     * - Compute the current container area.
     * - Move the pointer that has the smaller height.
     * 
     * Why move the shorter pointer?
     * 
     * Because the container height is limited by the shorter wall.
     * Moving the taller wall only reduces width without improving height.
     * Moving the shorter wall may find a taller line and increase the area.
     * 
     * Algorithm:
     * - left = 0
     * - right = n - 1
     * - while left < right
     * - width = right - left
     * - height = min(height[left], height[right])
     * - area = width × height
     * - update maxArea
     * 
     * - if height[left] < height[right]
     * left++
     * else
     * right--
     * 
     * Time Complexity:
     * O(n)
     * 
     * Auxiliary Space:
     * O(1)
     */

    public static int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int pillarHeight = Math.min(height[left], height[right]);
            int localMaxWater = width * pillarHeight;

            if (localMaxWater > maxWater) {
                maxWater = localMaxWater;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }
}

/*
 * Dry Run:
 * 
 * Input:
 * height = [1,8,6,2,5,4,8,3,7]
 * 
 * Initial State:
 * left = 0 (height = 1)
 * right = 8 (height = 7)
 * 
 * Iteration 1:
 * width = 8
 * height = min(1, 7) = 1
 * area = 8
 * maxWater = 8
 * 
 * Move left pointer (shorter wall).
 * 
 * Iteration 2:
 * left = 1 (height = 8)
 * right = 8 (height = 7)
 * 
 * width = 7
 * height = min(8, 7) = 7
 * area = 49
 * maxWater = 49
 * 
 * Move right pointer.
 * 
 * Remaining iterations do not produce a larger area.
 * 
 * Final Output:
 * 49
 */