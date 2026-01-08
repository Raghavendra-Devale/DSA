/*
 * Given an array a[ ] of size N. 
 * The task is to find the median and mean of the array elements. 
 * Mean is average of the numbers and median is the element which is smaller 
 * than half of the elements and greater than remaining half.  
 * If there are odd elements, the median is simply the middle element in the sorted array. 
 * If there are even elements, then the median is floor of average of two middle numbers in the sorted array. 
 * If mean is floating point number, then we need to print floor of it.
 * Note: To find the median, you might need to sort the array. 
 * Since sorting is covered in later tracks, we have already provided the sort function to you 
 * in the code.
 */

package Arrays.Easy;

import java.util.Arrays;

public class MeanMedian {
   /* Median = [(x /n2 + x n2+1)2] floor of average of two middle elements
    * For {1,3,4,6}, median = ⌊3+4⌋/2= ⌊3.5⌋=3
    */
    public static int median(int A[], int N) {
        Arrays.sort(A); // first sort array
        int mid1 = A[N/2 - 1]; // find the mid 1 for even number {1,3,4,6} = (4/2)-1 = 1. index;
        int mid2 = A[N/2];// finding mid 2 (4/2) = 2. index;
        double med = 0; 
        if (N % 2 == 0) {
            med = (mid1+mid2)/2.0; // ex: {1,3,4,6} = (3 + 4)/2 = avg(3.5) =3
            return (int) med; 
        }else{
            med = A[N/2]; //  odd number of size return it by dividing / 2 
        }
       return (int)med;
    }

    // for mean sum all elements and divide by total size return it 
    public static int mean(int A[], int N) {
        int mean = 0;
        for (int i = 0; i < A.length; i++) {
            mean += A[i];
        }    
        return mean/N;
    }


    public static void main(String[] args) {
        int arr[] =  {2, 8, 3, 4};
       System.out.println("mean is "+ mean(arr, arr.length)+"\nMedian "+median(arr, arr.length));        
    }
}
