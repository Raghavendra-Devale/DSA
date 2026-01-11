/*
Problem no 11
https://leetcode.com/problems/container-with-most-water/description/?envType=problem-list-v2&envId=array
 */

package Arrays.Medium;

public class ContainerWithMostWater11 {
    public static int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            int pillarHeight = Math.min(height[left], height[right]);
            int localMaxWater = width * pillarHeight;

            if(localMaxWater > maxWater) {
                maxWater = localMaxWater;
            }
            if (height[left] < height[right]) {
                left++;
            }else  {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println(maxArea( new int[] {1,8,6,2,5,4,8,3,7}));
    }

}
