/*
Problem:
Given an array of size N, find the mean and median of the array.

Definitions:
- Mean: Average of all elements. If the result is a floating-point value,
  return its floor.
- Median:
  - If N is odd → middle element of the sorted array.
  - If N is even → floor of the average of the two middle elements.

Note:
The array must be sorted to calculate the median.
*/

package Arrays.Easy;

import java.util.Arrays;

public class MeanMedian {

    /*
    Median Calculation:

    Approach:
    1) Sort the array.
    2) If N is even:
       - Find the two middle elements.
       - Return the floor of their average.
    3) If N is odd:
       - Return the middle element directly.

    Time Complexity:
    O(n log n) — due to sorting.

    Auxiliary Space:
    O(1) — ignoring sort’s internal space.
    */
    public static int median(int A[], int N) {
        Arrays.sort(A);

        int mid1 = A[N / 2 - 1];
        int mid2 = A[N / 2];
        double med = 0;

        if (N % 2 == 0) {
            med = (mid1 + mid2) / 2.0;
            return (int) med;
        } else {
            med = A[N / 2];
        }
        return (int) med;
    }

    /*
    Mean Calculation:

    Approach:
    - Sum all elements of the array.
    - Divide the sum by total number of elements.
    - Integer division automatically returns the floor.

    Time Complexity:
    O(n)

    Auxiliary Space:
    O(1)
    */
    public static int mean(int A[], int N) {
        int mean = 0;
        for (int i = 0; i < A.length; i++) {
            mean += A[i];
        }
        return mean / N;
    }

    public static void main(String[] args) {
        int arr[] = {2, 8, 3, 4};
        System.out.println("mean is " + mean(arr, arr.length)
                + "\nMedian " + median(arr, arr.length));
    }
}

/*
Dry Run:

Input:
arr = {2, 8, 3, 4}
N = 4

Mean Calculation:
Sum = 2 + 8 + 3 + 4 = 17
Mean = 17 / 4 = 4

Median Calculation:
Sorted array = {2, 3, 4, 8}
Middle elements = 3 and 4
Median = floor((3 + 4) / 2) = floor(3.5) = 3

Output:
mean is 4
Median 3
*/
