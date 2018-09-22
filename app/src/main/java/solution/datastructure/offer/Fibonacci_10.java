package solution.datastructure.offer;

public class Fibonacci_10 {

    public static long fibonacciWithRecursion(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacciWithRecursion(n - 1) + fibonacciWithRecursion(n - 2);
    }

    public static long fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long fibNOne = 0;
        long fibNTwo = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibNOne + fibNTwo;
            fibNOne = fibNTwo;
            fibNTwo = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(45));
        System.out.println(fibonacciWithRecursion(45));
    }

}
