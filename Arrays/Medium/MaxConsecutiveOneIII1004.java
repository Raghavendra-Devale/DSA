package Arrays.Medium;

/**
 * LeetCode 1004 - Max Consecutive Ones III
 *
 * Problem:
 * Given a binary array `nums` and an integer `k`, return the maximum number
 * of consecutive 1's in the array if you can flip at most `k` 0's to 1's.
 *
 * In other words: find the longest subarray that contains at most `k` zeros.
 */
public class MaxConsecutiveOneIII1004 {

    /**
     * Approach 1: Brute Force
     *
     * For every starting index `i`, expand the window to the right as far as
     * possible while the number of zeros encountered stays within the allowed
     * limit `k`. Track the maximum window length seen.
     *
     * Time Complexity  : O(n^2)
     *   - Outer loop runs n times (for each starting index i).
     *   - Inner loop can run up to n times in the worst case for each i.
     *
     * Space Complexity : O(1)
     *   - Only a few extra variables (ans, zeros) are used; no extra data
     *     structures that grow with input size.
     */
    public static int longestOnesBrute(int[] nums, int k) {
        int ans = 0;

        // Try every possible starting index for the window
        for (int i = 0; i < nums.length; i++) {
            int zeros = 0; // count of zeros in the current window [i, j]

            // Expand the window from i as far right as possible
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeros++;
                }

                // Too many zeros -> this window (and any longer one from i) is invalid
                if (zeros > k) {
                    break;
                }

                // Valid window -> update the answer with its length
                ans = Math.max(ans, j - i + 1);
            }
        }

        return ans;
    }

    /**
     * Approach 2: Sliding Window (Optimal)
     *
     * Maintain a window [left, right] that can contain at most `k` zeros.
     * Expand `right` one step at a time; whenever the zero count exceeds `k`,
     * shrink the window from the left until it's valid again. Because both
     * pointers only move forward, the total work is linear.
     *
     * Time Complexity  : O(n)
     *   - `right` traverses the array once.
     *   - `left` also moves forward at most n times total (never resets),
     *     so the while loop across the whole run does O(n) work, not O(n) per step.
     *
     * Space Complexity : O(1)
     *   - Only constant extra space (ans, left, zeros) regardless of input size.
     *
     * ---------------------------------------------------------------------
     * DRY RUN  (nums = {1,1,1,0,0,0,1,1,1,1,0}, k = 2)
     *
     * index:  0  1  2  3  4  5  6  7  8  9  10
     * value:  1  1  1  0  0  0  1  1  1  1  0
     *
     * right=0  val=1  zeros=0                 window=[0,0]  len=1  ans=1
     * right=1  val=1  zeros=0                 window=[0,1]  len=2  ans=2
     * right=2  val=1  zeros=0                 window=[0,2]  len=3  ans=3
     * right=3  val=0  zeros=1                 window=[0,3]  len=4  ans=4
     * right=4  val=0  zeros=2                 window=[0,4]  len=5  ans=5
     * right=5  val=0  zeros=3 -> zeros > k, shrink:
     *              nums[left=0]=1 -> left=1        (zeros still 3)
     *              nums[left=1]=1 -> left=2        (zeros still 3)
     *              nums[left=2]=1 -> left=3        (zeros still 3)
     *              nums[left=3]=0 -> zeros=2, left=4   (loop stops, zeros<=k)
     *          window=[4,5]  len=2  ans=5 (unchanged, 2 < 5)
     * right=6  val=1  zeros=2                 window=[4,6]  len=3  ans=5
     * right=7  val=1  zeros=2                 window=[4,7]  len=4  ans=5
     * right=8  val=1  zeros=2                 window=[4,8]  len=5  ans=5
     * right=9  val=1  zeros=2                 window=[4,9]  len=6  ans=6  <- new max
     * right=10 val=0  zeros=3 -> zeros > k, shrink:
     *              nums[left=4]=0 -> zeros=2, left=5   (loop stops, zeros<=k)
     *          window=[5,10] len=6  ans=6 (unchanged, tie)
     *
     * Final answer = 6
     *   -> achieved by window [4..9] = {0,0,1,1,1,1} (flip the two 0's)
     *   -> or equivalently window [5..10] = {0,1,1,1,1,0}
     *
     * Key observation: `left` NEVER moves backward, and each index is only
     * ever added to / removed from the window once across the entire run.
     * That's why the nested while loop doesn't blow up the complexity to
     * O(n^2) -- total movement of `left` over all iterations is bounded by n.
     * ---------------------------------------------------------------------
     */
    public static int longestOnesSlidingWindow(int[] nums, int k) {
        int ans = 0;
        int left = 0;   // left boundary of the sliding window
        int zeros = 0;  // count of zeros currently inside the window

        for (int right = 0; right < nums.length; right++) {
            // Expand window by including nums[right]
            if (nums[right] == 0) {
                zeros++;
            }

            // Shrink window from the left while it has too many zeros
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // Window [left, right] is now guaranteed valid (<= k zeros)
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        // Brute force -> O(n^2) time, O(1) space
        System.out.println("Brute   " + longestOnesBrute(nums, k));

        // Sliding window -> O(n) time, O(1) space
        System.out.println("Sliding " + longestOnesSlidingWindow(nums, k));
    }
}
