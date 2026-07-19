package Foundations;

public class PowerOfTwo231 {

//    this approach return true for 6 still keeping as a mistake
    public static boolean isPowerOfTwoMistake(int n) {
        if (n == 1) return true;
        if (n <= 0 || n%2 != 0) return false;
        return true;
    }
// this gets time limit exceeded math don't work
    public static boolean isPowerOfTwoMath(int n) {
        if (n == 1) return true;
        if (n <= 0 || n % 2 != 0) return false;
        int num = 2;

        while (num <= n) {
            if(n == num) {
                return  true;
            }
            num = num * 2;
        }
        return false;
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static boolean isPowerOfTwoRecursive(int n) {
        if(n==1) return true;
        if(n<=0 || n%2 != 0){
            return false;
        }
        return isPowerOfTwo(n/2);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwoMath(16));
        System.out.println(isPowerOfTwoMistake(16));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwoRecursive(16));
    }
}
