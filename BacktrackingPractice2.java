import java.util.*;

public class BacktrackingPractice2 {

    public static void main(String[] args) {
        // Test Problem 1: Subsets II
        System.out.println("--- Problem 1: Subsets II (With Duplicates) ---");
        int[] nums1 = { 1, 2, 2 };
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + subsetsWithDup(nums1));
        System.out.println("Expected: [[], [1], [1,2], [1,2,2], [2], [2,2]]");

        // Test Problem 2: Combination Sum II
        System.out.println("\n--- Problem 2: Combination Sum II ---");
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println("Input: " + Arrays.toString(candidates) + ", target = " + target);
        System.out.println("Output: " + combinationSum2(candidates, target));
        System.out.println("Expected: [[1,1,6], [1,2,5], [1,7], [2,6]]");

        // Test Problem 3: Letter Case Permutation
        System.out.println("\n--- Problem 3: Letter Case Permutation ---");
        String s1 = "a1b2";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + letterCasePermutation(s1));
        System.out.println("Expected: [\"a1b2\",\"a1B2\",\"A1b2\",\"A1B2\"]");

        // Test Problem 4: Binary Watch
        System.out.println("\n--- Problem 4: Binary Watch ---");
        int turnedOn = 1;
        System.out.println("Input: turnedOn = " + turnedOn);
        System.out.println("Output: " + readBinaryWatch(turnedOn));
        System.out.println(
                "Expected: [\"0:01\",\"0:02\",\"0:04\",\"0:08\",\"0:16\",\"0:32\",\"1:00\",\"2:00\",\"4:00\",\"8:00\"]");

        // Test Problem 5: N-Queens (Simplified - Count Solutions)
        System.out.println("\n--- Problem 5: N-Queens (Count Solutions) ---");
        int n = 4;
        System.out.println("Input: n = " + n);
        System.out.println("Output: " + totalNQueens(n));
        System.out.println("Expected: 2");

        // Test Problem 6: Word Search
        System.out.println("\n--- Problem 6: Word Search ---");
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        System.out.println("Word: \"" + word1 + "\" -> " + exist(board, word1) + " (Expected: true)");
        System.out.println("Word: \"" + word2 + "\" -> " + exist(board, word2) + " (Expected: true)");
        System.out.println("Word: \"" + word3 + "\" -> " + exist(board, word3) + " (Expected: false)");
    }

    /**
     * Problem 1: Subsets II (With Duplicates)
     * 
     * Given an integer array nums that may contain duplicates, return all possible
     * subsets (the power set).
     * The solution set must not contain duplicate subsets. Return the solution in
     * any order.
     * 
     * Example:
     * Input: nums = [1,2,2]
     * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     * 
     * Constraints:
     * - 1 <= nums.length <= 10
     * - -10 <= nums[i] <= 10
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubset(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrackSubset(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        current.sort(Comparator.naturalOrder());

        if (!result.contains(current)) {
            result.add(new ArrayList<>(current));
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrackSubset(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    /**
     * Problem 2: Combination Sum II
     * 
     * Given a collection of candidate numbers and a target number, find all unique
     * combinations where the candidate numbers sum to target.
     * Each number in candidates may only be used ONCE in the combination.
     * 
     * Example:
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
     * 
     * Constraints:
     * - 1 <= candidates.length <= 100
     * - 1 <= candidates[i] <= 50
     * - 1 <= target <= 30
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackCombinationSum(candidates, target, new ArrayList<>(), 0, result);
        return result;
    }

    private static void backtrackCombinationSum(int[] candidates, int target, List<Integer> current, int start,
            List<List<Integer>> result) {
        if (sum(current) == target && !result.contains(current)) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrackCombinationSum(candidates, target, current, i + 1, result);
            current.remove(current.size() - 1);
        }
    }

    private static int sum(List<Integer> current) {
        int sum = 0;
        for (int num : current) {
            sum += num;
        }
        return sum;
    }

    /**
     * Problem 3: Letter Case Permutation
     * 
     * Given a string s, you can transform every letter individually to be
     * lowercase or uppercase to create another string.
     * Return a list of all possible strings we could create. Return the output in
     * any order.
     * 
     * Example:
     * Input: s = "a1b2"
     * Output: ["a1b2","a1B2","A1b2","A1B2"]
     * 
     * Example 2:
     * Input: s = "3z4"
     * Output: ["3z4","3Z4"]
     * 
     * Constraints:
     * - 1 <= s.length <= 12
     * - s consists of lowercase English letters, uppercase English letters, and
     * digits.
     */
    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        // TODO: Implement this
        return result;
    }

    /**
     * Problem 4: Binary Watch
     * 
     * A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6
     * LEDs on the bottom to represent the minutes (0-59).
     * Each LED represents a zero or one, with the least significant bit on the
     * right.
     * 
     * Given an integer turnedOn which represents the number of LEDs that are
     * currently on (ignoring the PM),
     * return all possible times the watch could represent. You may return the
     * answer in any order.
     * 
     * The hour must not contain a leading zero.
     * - For example, "01:00" is not valid. It should be "1:00".
     * The minute must consist of two digits and may contain a leading zero.
     * - For example, "10:2" is not valid. It should be "10:02".
     * 
     * Example:
     * Input: turnedOn = 1
     * Output:
     * ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
     * 
     * Constraints:
     * - 0 <= turnedOn <= 10
     */
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        // TODO: Implement this
        return result;
    }

    /**
     * Problem 5: N-Queens (Simplified - Count Solutions Only)
     * 
     * The n-queens puzzle is the problem of placing n queens on an n x n
     * chessboard such that no two queens attack each other.
     * Given an integer n, return the number of distinct solutions to the n-queens
     * puzzle.
     * 
     * Queens can attack horizontally, vertically, and diagonally.
     * 
     * Example:
     * Input: n = 4
     * Output: 2
     * Explanation: There are two distinct solutions to the 4-queens puzzle.
     * 
     * Constraints:
     * - 1 <= n <= 9
     */
    public static int totalNQueens(int n) {
        // TODO: Implement this
        return 0;
    }

    /**
     * Problem 6: Word Search
     * 
     * Given an m x n grid of characters board and a string word, return true if
     * word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cells,
     * where adjacent cells are horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     * 
     * Example:
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
     * word = "ABCCED"
     * Output: true
     * 
     * Example 2:
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
     * word = "SEE"
     * Output: true
     * 
     * Example 3:
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
     * word = "ABCB"
     * Output: false
     * 
     * Constraints:
     * - m == board.length
     * - n = board[i].length
     * - 1 <= m, n <= 6
     * - 1 <= word.length <= 15
     * - board and word consists of only lowercase and uppercase English letters.
     */
    public static boolean exist(char[][] board, String word) {
        // TODO: Implement this
        return false;
    }
}
