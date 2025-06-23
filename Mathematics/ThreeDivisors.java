/*
 * Given a positive integer value n. The task is to find how many numbers less than or equal to n 
 * have numbers of divisors exactly 3.
 * Examples: 
 * Input: n = 6
 * Output: 1
 * Explanation: The only number less than 6 with 3 divisors is 4 which has 
 * 1, 2 and 4 as divisors.
 * 
 * Input: n = 10
 * Output: 2
 * Explanation: 4 and 9 have 3 divisors.
 * Constraints : 1 ≤ n ≤ 109
 */


 // A number has exactly 3 positive divisors only if it is the square of a prime number

// **leet code link https://leetcode.com/problems/three-divisors/**
 public class ThreeDivisors {
    
    public static boolean isPrime(int n){
        if (n<2) return false;
        for (int i = 2; i * i <= n; i++) {
            System.out.println("Checking if " + n + " is divisible by " + i);
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int exactly3Divisors(int n){
        int count = 0;
        for (int i = 2; i*i <= n; i++) {
            if (isPrime(i)) {
                // System.out.println("here num "+i);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int ans  = exactly3Divisors(6);
        System.out.println("count "+ ans);
        // System.out.println(exactly3Divisors(20));
        // System.out.println(exactly3Divisors(12));
    }
 }







 
 /* leetcode solution
  * class Solution {
   
    public boolean isThree(int n) {
       int sqr = (int)Math.sqrt(n);
       if(sqr * sqr !=n) return false;
       return isPrime(sqr);
    }
    public boolean isPrime(int sqr){
        if(sqr<2) return false;
        for(int i = 2; i * i <= sqr; i++){
            if(sqr%i==0) return false;
        }
        return true;
    }
}
  */