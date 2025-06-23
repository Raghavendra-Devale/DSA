/*
 * Given the first 2 terms A and B of a Geometric Series. 
 * The task is to find the Nth term of the series.
 * Example 1: 
 * Input: A = 2 B = 3 N = 1
 * Output: 2
 * Explanation: A geometric progression (GP) is a list of numbers where each number is 
 * multiplied by the same value to get the next one.
 */

public class GP_Term {

    static double ans;
    static double findGP(int A, int B, int n){
        double ratio =(double) B/A;       //Nth term = a × rⁿ⁻¹ 
        ans =  A*Math.pow(ratio, n-1);    // nth term = first term * ratio ^ n-1
        return ans;
    }
    public static void main(String[] args) {
        double ans = findGP(2, 3, 1);
        System.out.println(ans);
    }
}
