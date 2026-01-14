/*
Problem:
Given an array of size N containing positive integers (may include duplicates),
find the largest and second largest elements such that both are distinct.
If no second largest element exists, return -1 as the second value.

Output:
Return both values in an ArrayList.
*/

package Arrays.Medium;

import java.util.ArrayList;

public class MaxAndSecondMax {

    /*
    Approach (Single Traversal):

    Idea:
    - Maintain two variables:
      1) largest
      2) secondLargest
    - Traverse the array once and update these values accordingly.

    Steps:
    1) If current element > largest:
       - secondLargest = largest
       - largest = current element
    2) Else if current element is smaller than largest but greater than secondLargest:
       - Update secondLargest

    This ensures both values are distinct.

    Time Complexity:
    O(n)

    Auxiliary Space:
    O(1)
    */
    static ArrayList<Integer> largestAndSecondLargest(int arr[], int n){

        ArrayList<Integer> res = new ArrayList<>();

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++ ){

            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
            else if (arr[i] != largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        res.add(largest);

        if(secondLargest == Integer.MIN_VALUE){
            res.add(-1);
        } else {
            res.add(secondLargest);
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 5, 8};
        ArrayList<Integer> res = largestAndSecondLargest(arr, arr.length);
        System.out.println(res);
    }
}

/*
Dry Run:

Input:
arr = {1, 2, 3, 4, 5, 5, 8}

Iteration:
i=0 → largest=1, secondLargest=MIN
i=1 → largest=2, secondLargest=1
i=2 → largest=3, secondLargest=2
i=3 → largest=4, secondLargest=3
i=4 → largest=5, secondLargest=4
i=5 → duplicate 5 → ignored
i=6 → largest=8, secondLargest=5

Output:
[8, 5]
*/
