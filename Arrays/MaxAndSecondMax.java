/* Given an array arr[] of size N of positive integers which may have duplicates. 
 * The task is to find the maximum and second maximum from the array,
 * and both of them should be different from each other, so If no second max exists, 
 * then the second max will be -1.
 * Example 1:
 * Input: N = 3 arr[] = {2,1,2}
 * Output: 2 1
 * Explanation: From the given array elements, 2 is the largest and 1 is the second largest.
 * Example 2:
 * Input:
 * N = 5 arr[] = {1,2,3,4,5}
 * Output: 5 4
 * Explanation: From the given array elements, 5 is the largest and 4 is the second largest.
 */

 package Arrays;

import java.util.ArrayList;

public class MaxAndSecondMax {
    static ArrayList<Integer> largestAndSecondLargest(int arr[],int n){
        // Taking an array list result to return answer
        ArrayList<Integer> res = new ArrayList<>();
        // Assigning the smallest values to both large and second large 
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // iteraring the whole array 
        for(int i = 0; i < n; i++ ){
            /* if array element is greater than our largest then 
            largest becomes second largest and the array element is assigned to largest */
            if (arr[i] > largest ) {
                secondLargest = largest;            
                largest = arr[i];              
            }
            /*if the current element is lesser than our largest and bigger than second largest  */
            else if (arr[i] != largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
          
        }
        //add largest to array
        res.add(largest);
        // check if second large is not updated at all if not found assign -1
        if(secondLargest == Integer.MIN_VALUE){
            res.add(-1);
        }
        // if found add  secondlargest and return
        else{
            res.add(secondLargest);
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,5,8};
        ArrayList<Integer> res = new ArrayList<>();
        res = largestAndSecondLargest(arr, arr.length);
        System.out.println(res);
    }    
}
