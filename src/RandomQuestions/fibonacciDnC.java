package RandomQuestions;

public class fibonacciDnC {
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);  // Divide problem into subproblems
    }

    public static void main(String[] args) {
        int n = 20;

        long startTime = System.nanoTime();  // Start timer

        int result = fib(n);

        long endTime = System.nanoTime();    // End timer

        System.out.println("Fibonacci(" + n + ") = " + result);
        System.out.println("Time taken: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}

