/*
Problem:
Given an array of positive integers, find the maximum value of (j - i)
such that:
- arr[i] < arr[j]
- i < j

The task is to maximize the index difference under the given condition.
*/

package Arrays.Easy;

public class MaxIndex {

    /*
    Brute Force Approach:

    Approach:
    - Use two nested loops.
    - Fix index i and scan from the end of the array for index j.
    - If arr[i] < arr[j], compute (j - i).
    - Track the maximum difference found.

    Time Complexity:
    O(n²) — due to nested loops.

    Auxiliary Space:
    O(1)
    */
    static int maxIndexDiffBrute(int[] arr){
        int maxxDiff = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] < arr[j]) {
                    maxxDiff = Math.max(maxxDiff, j - i);
                }
            }
        }
        return maxxDiff;
    }

    /*
    Optimal Approach (Prefix Min + Suffix Max):

    Key Idea:
    - Precompute two helper arrays:
      1) lMin[i]: minimum value from index 0 to i
      2) rMax[j]: maximum value from index j to n-1

    - Use two pointers i and j:
      - If lMin[i] <= rMax[j], it means there exists
        a valid pair (i, j), so update max difference and move j.
      - Otherwise, move i forward.

    This avoids checking all pairs explicitly.

    Time Complexity:
    O(n) — linear traversal after preprocessing.

    Auxiliary Space:
    O(n) — for lMin and rMax arrays.
    */
    static int maxIndexDiffOptimal(int []arr){
        int n = arr.length;
        int[] lMin = new int[n];
        int[] rMax = new int[n];

        lMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            lMin[i] = Math.min(arr[i], lMin[i - 1]);
        }

        rMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(arr[i], rMax[i + 1]);
        }

        int i = 0, j = 0, maxDiff = 0;
        while (i < n && j < n) {
            if (lMin[i] <= rMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        // Brute Force:
        // System.out.println(maxIndexDiffBrute(arr));

        System.out.println(maxIndexDiffOptimal(arr));
    }
}

/*
Dry Run (Optimal Approach):

Input:
arr = [34, 8, 10, 3, 2, 80, 30, 33, 1]

Step 1: Build lMin array
lMin = [34, 8, 8, 3, 2, 2, 2, 2, 1]

Step 2: Build rMax array
rMax = [80, 80, 80, 80, 80, 80, 33, 33, 1]

Step 3: Two-pointer traversal
i = 0, j = 0 → lMin[0] <= rMax[0] → maxDiff = 0
i = 0, j = 5 → lMin[0] <= rMax[5] → maxDiff = 5
i = 1, j = 5 → lMin[1] <= rMax[5] → maxDiff = 4
...
Best pair found:
i = 1 (value 8), j = 5 (value 80)

Maximum Index Difference:
5 - 1 = 4

Output:
4
*/
