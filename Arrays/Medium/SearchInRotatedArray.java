package Arrays.Medium;

public class SearchInRotatedArray {
    public static int search(int[] nums, int target) {
        int result = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == target) {
                return l;
            } else if (nums[r] == target) {
                return r;
            }
            l++;
            r--;
        }return result;
    }
    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
