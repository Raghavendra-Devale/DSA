/*
 * Given a positive integer N. The task is to find factorial of N.
 */


public class Factorial {
    //Loop version
    public static long factorial(int N){
        long result = 1;
        
        for (int i = 1; i <= N; i++) {
            result *= i;
            
        }
        return result;
    }
    // Recursive version
    static long factorialRecurse(int n){
        if (n <=1 ) return 1;
        return n * factorialRecurse(n-1);
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Loop version "+factorial(n));
        System.out.println("Recursive version "+factorialRecurse(n));
    }
}

