/*
 * Given an array arr of positive integers. 
 * The task is to return the maximum of j - i subjected to 
 * the constraint of arr[i] < arr[j] and i < j.
 */
package Arrays;

public class MaxIndex {
    // Brute force approach here were scanning whole from left to right and if arr[i] element 
    // is lesser than arr[j] element assign the difference between them to result and return
   
    static int maxIndexDiffBrute(int[] arr){
        int maxxDiff = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j > i; j--) {
                if (arr[i]<arr[j]) {
                    maxxDiff = Math.max(maxxDiff, j-i);
                }
            }
        }
        return maxxDiff;
    }











    

    // Optimal approach
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
        // BruteForce         System.out.println(maxIndexDiffBrute(arr));
        System.out.println(maxIndexDiffOptimal(arr));

    }
}




/* I copied that optimal one from chatgpt the below is my version 
 * it works for small inputs 
 * int n = arr.length;
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
        if (lMin[i] < rMax[j]) {
            maxDiff = Math.max(maxDiff, j - i);
            j++;
        } else {
            i++;
        }
    }

    return maxDiff;
 */