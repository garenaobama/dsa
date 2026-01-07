import java.util.*;

public class BacktrackingProblems {

    public static void main(String[] args) {
        // Test Subsets
        System.out.println("--- Subsets ---");
        int[] nums1 = { 1, 2, 3 };
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + subsets(nums1));
        // Expected: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]

        // Test Permutations
        System.out.println("\n--- Permutations ---");
        int[] nums2 = { 1, 2, 3, 4 };
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + permute(nums2));
        // Expected: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
    }

    /**
     * Problem 1: Subsets (Power Set)
     * Given an integer array nums of unique elements, return all possible subsets.
     * 
     * Example: [1,2,3] -> [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
     * 
     * Approach: Backtracking
     * - At each index, we have 2 choices: include or exclude the element.
     * - Use a helper function with current subset and start index.
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    // Helper method for subsets
    private static void backtrackSubsets(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // 1. Add current subset to result (every state is valid).
        result.add(new ArrayList<>(current));

        // 2. For each element from 'start' to end:
        for (int i = start; i < nums.length; i++) {
            // a. CHOOSE: Add element to current.
            current.add(nums[i]);

            // b. EXPLORE: Recurse with i+1 (not start+1, to avoid duplicates).
            backtrackSubsets(nums, i + 1, current, result);

            // c. UNCHOOSE: Remove element from current (backtrack).
            current.remove(current.size() - 1);
        }
    }

    /**
     * Problem 2: Permutations
     * Given an array nums of distinct integers, return all possible permutations.
     * 
     * Example: [1,2,3] -> [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
     * 
     * Approach: Backtracking
     * - At each position, try every unused element.
     * - Use a Set or boolean array to track which elements are used.
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackPermute(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    // Helper method for permutations
    private static void backtrackPermute(int[] nums, List<Integer> current, boolean[] used,
            List<List<Integer>> result) {
        // TODO: Implement this helper
        // 1. Base case: if current.size() == nums.length, add to result.
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        // 2. For each element in nums:
        for (int i = 0; i < nums.length; i++) {
            // a. Skip if already used.
            if (used[i])
                continue;
            // b. CHOOSE: Mark as used, add to current.
            current.add(nums[i]);
            used[i] = true;
            // c. EXPLORE: Recurse.
            backtrackPermute(nums, current, used, result);
            // d. UNCHOOSE: Mark as unused, remove from current.
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
