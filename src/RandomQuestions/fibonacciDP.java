package RandomQuestions;

public class fibonacciDP {
    public static int fib(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
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

