import java.util.*;

public class BacktrackingPractice {

    public static void main(String[] args) {
        // Test Problem 1: Combination Sum
        System.out.println("--- Problem 1: Combination Sum ---");
        int[] candidates1 = { 2, 3, 6, 7 };
        int target1 = 7;
        System.out.println("Input: " + Arrays.toString(candidates1) + ", target = " + target1);
        System.out.println("Output: " + combinationSum(candidates1, target1));
        System.out.println("Expected: [[2,2,3], [7]]");

        // Test Problem 2: Letter Combinations
        System.out.println("\n--- Problem 2: Letter Combinations of Phone Number ---");
        String digits = "23";
        System.out.println("Input: \"" + digits + "\"");
        System.out.println("Output: " + letterCombinations(digits));
        System.out.println("Expected: [\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]");

        // Test Problem 3: Generate Parentheses
        System.out.println("\n--- Problem 3: Generate Parentheses ---");
        int n = 3;
        System.out.println("Input: n = " + n);
        System.out.println("Output: " + generateParenthesis(n));
        System.out.println("Expected: [\"((()))\",\"(()())\",\"(())()\",\"()(())\",\"()()()\"]");

        // Test Problem 4: Palindrome Partitioning
        System.out.println("\n--- Problem 4: Palindrome Partitioning ---");
        String s = "aab";
        System.out.println("Input: \"" + s + "\"");
        System.out.println("Output: " + partition(s));
        System.out.println("Expected: [[\"a\",\"a\",\"b\"], [\"aa\",\"b\"]]");

        // Test Problem 5: Combinations
        System.out.println("\n--- Problem 5: Combinations ---");
        int n2 = 4, k = 2;
        System.out.println("Input: n = " + n2 + ", k = " + k);
        System.out.println("Output: " + combine(n2, k));
        System.out.println("Expected: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]");
    }

    /**
     * Problem 1: Combination Sum
     * 
     * Given an array of distinct integers 'candidates' and a target integer
     * 'target',
     * return all unique combinations where the chosen numbers sum to target.
     * You may use the same number UNLIMITED times.
     * 
     * Example:
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3], [7]]
     * 
     * Hint: Similar to Subsets, but:
     * - Only add to result when sum == target
     * - You can reuse the same element (so recurse with 'i', not 'i+1')
     * - Stop early if sum > target (pruning)
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Call your backtracking helper here
        backtrackCombinationSum(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrackCombinationSum(int[] candidates, int target, int start, int currentSum,
            List<Integer> current, List<List<Integer>> result) {
        // TODO: Implement this
        // 1. Base case: if currentSum == target, add current to result
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        // 2. If currentSum > target, return (pruning)
        if (currentSum > target)
            return;
        // 3. Loop from start to end:
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            currentSum += candidates[i];
            backtrackCombinationSum(candidates, target, i, currentSum, current, result);
            currentSum -= candidates[i];
            current.remove(current.size() - 1);
        }
    }

    /**
     * Problem 2: Letter Combinations of a Phone Number
     * 
     * Given a string containing digits from 2-9, return all possible letter
     * combinations that the number could represent (like old phone keypads).
     * 
     * Mapping:
     * 2 -> "abc", 3 -> "def", 4 -> "ghi", 5 -> "jkl",
     * 6 -> "mno", 7 -> "pqrs", 8 -> "tuv", 9 -> "wxyz"
     * 
     * Example:
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 
     * Hint:
     * - Create a map/array for digit -> letters
     * - At each position, try all letters for that digit
     * - Base case: when current string length == digits length
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;

        // Map digits to letters
        String[] phone = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        // TODO: Call your backtracking helper
        backtrackLetterCombinations(digits, 0, new StringBuilder(), phone, result);
        return result;
    }

    private static void backtrackLetterCombinations(String digits, int index, StringBuilder current, String[] phone,
            List<String> result) {
        // TODO: Implement this
        // 1. Base case: if index == digits.length(), add current to result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        // 2. Get the letters for current digit: phone[digits.charAt(index) - '0']
        StringBuilder letters = new StringBuilder(phone[digits.charAt(index) - '0']);
        // 3. Loop through each letter:
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrackLetterCombinations(digits, index + 1, current, phone, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    /**
     * Problem 3: Generate Parentheses
     * 
     * Given n pairs of parentheses, generate all combinations of well-formed
     * parentheses.
     * 
     * Example:
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * 
     * Hint:
     * - Track count of open '(' and close ')' parentheses
     * - Rules: can add '(' if open < n
     * can add ')' if close < open
     * - Base case: when current.length() == 2*n
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // TODO: Call your backtracking helper
        backtrackGenerateParenthesis(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrackGenerateParenthesis(int n, int open, int close, StringBuilder current,
            List<String> result) {
        // TODO: Implement this
        // 1. Base case: if current.length() == 2*n, add to result
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }
        // 2. If open < n: try adding '('
        // - CHOOSE: append '('
        // - EXPLORE: recurse with open+1
        // - UNCHOOSE: remove last char
        if (open < n) {
            current.append("(");
            backtrackGenerateParenthesis(n, open + 1, close, current, result);
            current.deleteCharAt(current.length() - 1);
        }
        // 3. If close < open: try adding ')'
        // - CHOOSE: append ')'
        // - EXPLORE: recurse with close+1
        // - UNCHOOSE: remove last char
        if (close < open) {
            current.append(")");
            backtrackGenerateParenthesis(n, open, close + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    /**
     * Problem 4: Palindrome Partitioning
     * 
     * Given a string s, partition s such that every substring is a palindrome.
     * Return all possible palindrome partitioning of s.
     * 
     * Example:
     * Input: s = "aab"
     * Output: [["a","a","b"], ["aa","b"]]
     * 
     * Hint:
     * - At each position, try all possible substrings starting from that position
     * - Only proceed if the substring is a palindrome
     * - Base case: when start index reaches end of string
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        // TODO: Call your backtracking helper
        backtrackPartition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrackPartition(String s, int start, List<String> current, List<List<String>> result) {
        // TODO: Implement this
        // 1. Base case: if start == s.length(), add current to result
        if (start == s.length()) {
            result.add(new ArrayList<>(current)); // IMPORTANT: Create a copy!
            return;
        }
        // 2. Loop from start to end:
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i + 1));
                backtrackPartition(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
        // - Extract substring from start to i
        // - If substring is palindrome:
        // - CHOOSE: add substring to current
        // - EXPLORE: recurse with i+1
        // - UNCHOOSE: remove last element
    }

    // Helper: Check if a string is palindrome
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * Problem 5: Combinations
     * 
     * Given two integers n and k, return all possible combinations of k numbers
     * chosen from the range [1, n].
     * 
     * Example:
     * Input: n = 4, k = 2
     * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
     * 
     * Hint:
     * - Very similar to Subsets!
     * - Only add to result when current.size() == k
     * - Loop from start to n
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Call your backtracking helper
        backtrackCombine(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private static void backtrackCombine(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        // TODO: Implement this
        // 1. Base case: if current.size() == k, add to result
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        // 2. Loop from start to n:
        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrackCombine(n, k, start + i, current, result);
            current.remove(current.size() - 1);
        }
        // - CHOOSE: add i to current
        // - EXPLORE: recurse with i+1
        // - UNCHOOSE: remove last element
    }
}
