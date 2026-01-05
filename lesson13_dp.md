# Lesson 13: Dynamic Programming (DP)

## What is Dynamic Programming?
Dynamic Programming is a fancy name for **Recursion + Caching**. It's used when a problem can be broken down into:
1.  **Overlapping Subproblems**: The *same* small problems are solved multiple times.
2.  **Optimal Substructure**: The optimal solution to the big problem can be built from optimal solutions to the small problems.

> **Key Insight**: If we've solved a problem before, save the answer so we don't calculate it again!

## Two Approaches

### 1. Top-Down (Memoization)
*   **Strategy**: Start with the big problem and break it down recursively.
*   **Technique**: Use a `HashMap` or `Array` to store results of function calls.
*   **Pros**: Easy to write if you know recursion. Only solves subproblems that are needed.
*   **Cons**: Recursion depth limits (Stack Overflow).

### 2. Bottom-Up (Tabulation)
*   **Strategy**: Start with the smallest problems and build up to the big one.
*   **Technique**: clear Iteration (loops) filling a table (array).
*   **Pros**: No recursion overhead. Memory efficient (sometimes).
*   **Cons**: Need to determine the correct order of filling the table.

## Common Patterns vs Interview Questions
While interview questions often focus on specific algorithmic puzzles (like "Climbing Stairs" or "Coin Change"), real-world DP is often about **resource allocation** or **optimization** over time.

*   **Diff Utils**: Tools like `git diff` use a variation of DP (Longest Common Subsequence) to find the minimal set of changes between files.
*   **Text Justification**: LaTeX and word processors use DP to minimize the "ugliness" of line breaks in a paragraph.
*   **Seam Carving**: Resizing images intelligently by removing the "least important" pixels involves finding a path of minimum energy (DP).
*   **Bioinformatics**: DNA sequence alignment (Needleman-Wunsch algorithm) is classic DP.

## 1D vs 2D DP
*   **1D DP**: The state depends on one variable (e.g., `dp[i]`).
    *   *Example*: Fibonacci, Climbing Stairs.
*   **2D DP**: The state depends on two variables (e.g., `dp[i][j]`).
    *   *Example*: Grid paths, Edit Distance, Knapsack Problem.

## Practice Problems
1.  **Fibonacci (Memoization)**: Optimize the recursive standard.
2.  **Climbing Stairs**: You can climb 1 or 2 steps. How many ways to reach top?
3.  **Coin Change**: (Advanced) Fewest coins to make amount `X`.
