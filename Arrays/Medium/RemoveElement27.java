/*
LeetCode Problem 27:
Remove Element
https://leetcode.com/problems/remove-element/

Problem:
Given an integer array nums and an integer val,
remove all occurrences of val in-place and return the new length.
The order of elements may be changed.
*/

package Arrays.Medium;

public class RemoveElement27 {

    /*
    Approach (Two Pointers / Overwrite):

    Idea:
    - Use a pointer 'count' to track the position of valid elements.
    - Traverse the array:
      - If nums[i] is not equal to val, copy it to nums[count]
      - Increment count
    - After traversal, the first 'count' elements contain the result.

    Time Complexity:
    O(n)

    Auxiliary Space:
    O(1)
    */
    public static int removeElement(int[] nums, int val) {
        int count = 0;

        if (nums == null || nums.length == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }
}

/*
Dry Run:

Input:
nums = [0,1,2,2,3,0,4,2]
val = 2

Traversal:
i=0 → nums[0]=0 ≠ 2 → nums[0]=0 → count=1
i=1 → nums[1]=1 ≠ 2 → nums[1]=1 → count=2
i=2 → nums[2]=2 == 2 → skip
i=3 → nums[3]=2 == 2 → skip
i=4 → nums[4]=3 ≠ 2 → nums[2]=3 → count=3
i=5 → nums[5]=0 ≠ 2 → nums[3]=0 → count=4
i=6 → nums[6]=4 ≠ 2 → nums[4]=4 → count=5
i=7 → nums[7]=2 == 2 → skip

Final array (first 5 elements):
[0, 1, 3, 0, 4]

Output:
5
*/
