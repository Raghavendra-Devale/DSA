        /*
        * https://leetcode.com/problems/contains-duplicate-ii/description/?envType=problem-list-v2&envId=array
        */
package Arrays.Easy;

import java.util.HashSet;

public class ContainsDuplicateII {
            public static boolean bruteContainsNearbyDuplicate(int[] nums, int k) {
                // boolean res = false;
                int n = 0;
                for (int i = 0; i < nums.length; i++) {
                    for (int j = i+1; j < nums.length; j++) {
                            if (nums[i] == nums[j]) {
                            n = Math.abs(i - j);
                            if (n <= k) {
                            return true;
                            }
                        }     
                    }
                }return false;
            }

        
        public static boolean optimalContainsNearByDuplicate(int[] nums, int k){
            HashSet hSet = new HashSet<>();
            int n = 0;
            for (int i = 0; i < nums.length; i++) {
                if (hSet.contains(nums[i]) && hSet.size() <= k) {
                    n = Math.abs(nums[i]- nums[i+1]);
                }
                hSet.add(nums[i]);
            }
            if (n <= k) {
                return true;
            }
            return false;
        }



            
            public static void main(String[] args) {
                int arr[] = {1,0,1,1};
                int  k = 1;
                System.out.println(bruteContainsNearbyDuplicate(arr, k));

            }
        }
