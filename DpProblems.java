import java.util.*;

public class DpProblems {

    public static void main(String[] args) {
        // Test Fibonacci Memoization
        System.out.println("--- Fibonacci (Memoization) ---");
        int n = 10;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // Initialize memo table with -1
        System.out.println("Fib(" + n + ") = " + fibMemo(n, memo)); // Expected: 55

        // Test Climbing Stairs
        System.out.println("\n--- Climbing Stairs (Tabulation) ---");
        System.out.println("Ways to climb 3 steps: " + climbStairs(3)); // Expected: 3
        System.out.println("Ways to climb 5 steps: " + climbStairs(5)); // Expected: 8
    }

    /**
     * Problem 1: Fibonacci with Memoization (Top-Down)
     * Calculate the nth Fibonacci number efficiently.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * Recurrence: F(n) = F(n-1) + F(n-2)
     * Base cases: F(0) = 0, F(1) = 1
     */
    public static int fibMemo(int n, int[] memo) {
        // TODO: Implement this method using recursion + memoization.
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (memo[n] != -1)
            return memo[n];
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }

    /**
     * Problem 2: Climbing Stairs (Bottom-Up)
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps.
     * In how many distinct ways can you climb to the top?
     * 
     * Hint: This is exactly like Fibonacci!
     * dp[i] = dp[i-1] + dp[i-2]
     */
    public static int climbStairs(int n) {
        // Optimization: Space Complexity O(1)
        if (n <= 2)
            return n;

        int prev2 = 1; // Ways to reach step 1
        int prev1 = 2; // Ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
