/*
problem no 26
https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1259520843/?envType=problem-list-v2&envId=array
 */

package Arrays.Easy;

public class RemoveDuplicates26 {

    public static int ContainsDuplicate(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }return i+1;
    }
    public static void main(String[] args) {
        System.out.println(ContainsDuplicate(new int[]{1,1,1,1,1,1}));
    }
}
