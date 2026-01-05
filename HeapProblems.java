import java.util.*;

public class HeapProblems {

    public static void main(String[] args) {
        // Test K-th Largest
        System.out.println("--- K-th Largest Element ---");
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println("Array: " + Arrays.toString(nums) + ", k=" + k);
        System.out.println("Result: " + findKthLargest(nums, k)); // Expected: 5

        int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k2 = 4;
        System.out.println("\nArray: " + Arrays.toString(nums2) + ", k=" + k2);
        System.out.println("Result: " + findKthLargest(nums2, k2)); // Expected: 4
    }

    /**
     * Problem: Find the k-th largest element in an unsorted array.
     * Note: It is the k-th largest element in sorted order, not the k-th distinct
     * element.
     * 
     * Example: [3,2,1,5,6,4], k=2 -> 5 (Sorted: 1,2,3,4,5,6)
     * 
     * Approach: Use a Min-Heap of size K.
     * 1. Create a PriorityQueue (Min-Heap).
     * 2. Iterate through each number in the array.
     * 3. Add number to heap.
     * 4. If heap size > k, remove the smallest element (head).
     * 5. The peek of the heap is the k-th largest.
     */
    public static int findKthLargest(int[] nums, int k) {
        // APPROACH 1: Min-Heap (OPTIMAL - O(N log K))
        // Keep a heap of size K containing the K largest elements seen so far.
        // The smallest element in this heap is the K-th largest overall.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-Heap
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest (keeps top K largest)
            }
        }
        return minHeap.peek(); // Smallest of the top K = K-th largest

        // APPROACH 2: Max-Heap (LESS EFFICIENT - O(N log N + K log N))
        // Add all elements, then poll K times to get K-th largest.
        // Uncomment below to test:
        /*
         * PriorityQueue<Integer> maxHeap = new
         * PriorityQueue<>(Collections.reverseOrder());
         * for (int num : nums) {
         * maxHeap.add(num);
         * }
         * for (int i = 1; i < k; i++) {
         * maxHeap.poll(); // Remove largest K-1 times
         * }
         * return maxHeap.peek(); // K-th largest
         */
    }
}
