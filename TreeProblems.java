public class TreeProblems {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        System.out.println("===============================");
        System.out.println("       TREE PROBLEMS TEST      ");
        System.out.println("===============================");

        // Construct a sample tree:
        // 4
        // / \
        // 2 7
        // / \
        // 1 3
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7));

        System.out.println("Original Tree:");
        printTree(root);

        // Test Max Depth
        System.out.println("\n--- 1. Max Depth ------------------");
        System.out.println("Calculated Depth: " + maxDepth(root));
        System.out.println("Expected Depth:   3");

        // Test Search
        System.out.println("\n--- 2. Search BST -----------------");
        System.out.println("Search for 2: " + (searchBST(root, 2) != null ? "✔ FOUND" : "❌ NOT FOUND"));
        System.out.println("Search for 5: " + (searchBST(root, 5) != null ? "❌ FOUND" : "✔ NOT FOUND"));

        // Test Invert
        System.out.println("\n--- 3. Invert Tree ----------------");
        System.out.println("Inverting Tree...");
        invertTree(root);
        System.out.println("Inverted Tree Structure:");
        printTree(root);

        System.out.println("\n===============================");
    }

    // --- Visualization Helper ---
    public static void printTree(TreeNode root) {
        printSubtree(root, "", true);
    }

    private static void printSubtree(TreeNode node, String prefix, boolean isLast) {
        if (node == null)
            return;
        System.out.println(prefix + (isLast ? "└── " : "├── ") + node.val);
        printSubtree(node.left, prefix + (isLast ? "    " : "│   "), node.right == null);
        printSubtree(node.right, prefix + (isLast ? "    " : "│   "), true);
    }

    /**
     * Problem 1: Maximum Depth of Binary Tree
     */
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Problem 2: Invert Binary Tree
     * YOUR CODE REVIEW:
     * - Logic: CORRECT ✔️
     * - You correctly swapped the children and then recursively called invert on
     * them.
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        // Swap children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursion
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    /**
     * Problem 3: Search in a Binary Search Tree
     * YOUR CODE REVIEW:
     * - Logic: INCORRECT ❌
     * - Issue 1: You called `searchBST(root.left, val)` but ignored the return
     * value!
     * Recursion returns a value back to the caller. You must `return` it.
     * - Issue 2: Speed. You searched BOTH left and right (O(N)). In a BST, if val <
     * root,
     * we ONLY go left. If val > root, we ONLY go right (O(log N)).
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;

        // Optimized Logic: Only go one way!
        if (val < root.val) {
            return searchBST(root.left, val); // Return the result!
        } else {
            return searchBST(root.right, val); // Return the result!
        }
    }
}
