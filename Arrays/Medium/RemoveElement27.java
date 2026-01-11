/*
problem no 27
https://leetcode.com/problems/remove-element/description/?envType=problem-list-v2&envId=array
 */
package Arrays.Medium;

public class RemoveElement27 {
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        if(nums == null || nums.length == 0) return 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int [] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println( removeElement(nums, val));
    }
}
