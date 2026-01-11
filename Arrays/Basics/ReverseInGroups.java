/*
 * Given an array arr[] of positive integers. Reverse every sub-array group of size k.
 * Note: If at any instance, k is greater or equal to the array size, then reverse the entire array. 
 * You shouldn't return any array, modify the given array in place.
 * Examples: Input: arr[] = [1, 2, 3, 4, 5], k = 3
 * Output: [3, 2, 1, 5, 4]
 * Explanation: First group consists of elements 1, 2, 3. Second group consists of 4, 5.
 */

package Arrays.Basics;

public class ReverseInGroups {
    static void reverseInGroups(int[] arr, int k){
        int n = arr.length;
        if (k >= n) {
            reverseArrange(arr,0,n-1);
        }else{
            for(int i = 0; i < n; i += k){
                int start = i;
                int end = Math.min(i + k -1, n-1);
                reverseArrange(arr, i, end);
            }
        }
    }

    static void reverseArrange(int[] arr, int start, int end) {
        while (start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5}, k = 3;
        reverseInGroups(arr, k);
        for (int i : arr) {
            System.out.print(i +" ");
        }
    }    
}
