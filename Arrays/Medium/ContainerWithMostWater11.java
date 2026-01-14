/*
LeetCode Problem 11:
Container With Most Water
https://leetcode.com/problems/container-with-most-water/

Problem:
Given an array height where each element represents the height of a vertical line,
find two lines that together with the x-axis form a container that holds the maximum water.

The area of water is calculated as:
area = min(height[left], height[right]) × (right - left)
*/

package Arrays.Medium;

public class ContainerWithMostWater11 {

    /*
    Approach (Two Pointers + Greedy):

    Idea:
    - Start with two pointers at the extreme ends of the array.
    - The width is the distance between the two pointers.
    - The height of the container is limited by the shorter line.
    - To possibly increase area, move the pointer pointing to the shorter line.

    Why this works:
    - Moving the taller line inward can only decrease width without increasing height.
    - Moving the shorter line gives a chance to find a taller boundary.

    Time Complexity:
    O(n)

    Auxiliary Space:
    O(1)
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
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

/*
Dry Run:

Input:
height = [1,8,6,2,5,4,8,3,7]

Initial:
left = 0 (height 1)
right = 8 (height 7)

Iteration 1:
width = 8
height = min(1, 7) = 1
area = 8 × 1 = 8
Move left (shorter)

Iteration 2:
left = 1 (height 8), right = 8 (height 7)
width = 7
height = min(8, 7) = 7
area = 49 → maxWater = 49
Move right

Remaining iterations do not produce a larger area.

Output:
49
*/
