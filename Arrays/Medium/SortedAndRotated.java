/*
 * Given an array arr[] of N distinct integers, check if this array is Sorted 
 * (non-increasing or non-decreasing) and Rotated counter-clockwise.
 * Note that input array may be sorted in either increasing or decreasing order, then rotated.
 * A sorted array is not considered as sorted and rotated, i.e., 
 * there should be at least one rotation. 
 * Input: N = 4 arr[] = {3,4,1,2}
 * Output: Yes
 * Explanation: The array is sorted (1, 2, 3, 4) and rotated twice (3, 4, 1, 2).
 */
package Arrays.Medium;

/*
 * My solution :
 * if the array is sorted and rotated it should break atleast once we need to find that break
 * if it is only sorted no break at all 
 * if there is 2 or more breaks it is not sorted or rotated 
 * Ex: arr[] = {3,4,1,2}; it is sorted and rotated, here there is a break 3,4,1 there is break 
 * okay then in edge case arr[n-1] = 2 < arr[0] = 3; so true
 * 
 * Ex: arr[] = {3,4,1,2,5}; it is not sorted and rotated, here there is a break 3,4,1 there 
 * is break okay then in edge case arr[n-1] = 5 > arr[0] = 3;
 */




public class SortedAndRotated {

    public static boolean checkRotatedAndSorted(int arr[], int num) {
        int ascBreak = 0;

        int descBreak = 0;

        for (int i = 0; i < arr.length-1; i++) { // iterating the array 
            if (arr[i] < arr[i+1]) { // if the next number is higher than current number 
                //ascending order break ex: {1,2,3,4,2} 4,1 ascending break
                if (arr[i] > arr[i+1]) {
                    ascBreak++;
                }

                // if the next number is lesser that current number descending order break 
                //ex: {4,3,2,1,5} 1, descending break
                if (arr[i] < arr[i+1]) {
                    descBreak++;
                }
            }
            
        }
        // edge cases for ascending
        if (arr[num-1] < arr[0]) {
            ascBreak++;
        }
        // edge cases for descending
        if (arr[0] < arr[num-1]) {
            descBreak++;
        }
        //  either one of order has to be there and both should not be zero 
        if (ascBreak == 1 || descBreak == 1 && ascBreak != 0 && descBreak != 0 ) {
            return true;
        }
        return false;
        
    }

    public static void main(String[] args) {
        int arr[] = {3,4,1,2,5};
        System.out.println(checkRotatedAndSorted(arr, arr.length));
    }
    
}
