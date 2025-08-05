package RandomQuestions;

public class fibonacciDnC {
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);  // Divide problem into subproblems
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci number using D&C: " + fib(n));
    }
}

