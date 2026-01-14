/*
Problem:
Given an array of positive integers, reverse every sub-array of size k.
If k is greater than or equal to the array size, reverse the entire array.
The array must be modified in-place.

Approach:
1) If k >= array length:
   - Reverse the entire array in one go.
2) Otherwise:
   - Traverse the array in steps of size k.
   - For each group, calculate:
     - start index = current index
     - end index = min(current index + k - 1, last index)
   - Reverse the elements between start and end using a two-pointer technique.

Helper Method:
- reverseArrange() reverses a portion of the array in-place using swapping.

Time Complexity:
O(n) — each element is visited at most once.

Auxiliary Space:
O(1) — reversal is done in-place.
*/

package Arrays.Basics;

public class ReverseInGroups {

    static void reverseInGroups(int[] arr, int k){
        int n = arr.length;

        if (k >= n) {
            reverseArrange(arr, 0, n - 1);
        } else {
            for(int i = 0; i < n; i += k){
                int start = i;
                int end = Math.min(i + k - 1, n - 1);
                reverseArrange(arr, i, end);
            }
        }
    }

    static void reverseArrange(int[] arr, int start, int end) {
        while (start < end) {
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
            System.out.print(i + " ");
        }
    }
}

/*
Dry Run:

Input:
arr = [1, 2, 3, 4, 5]
k = 3

Step 1:
n = 5, k < n → proceed with group reversal

First Group:
start = 0, end = 2
Reverse [1, 2, 3] → [3, 2, 1]

Array now:
[3, 2, 1, 4, 5]

Second Group:
start = 3, end = min(3 + 3 - 1, 4) = 4
Reverse [4, 5] → [5, 4]

Final Array:
[3, 2, 1, 5, 4]

Output:
3 2 1 5 4
*/
