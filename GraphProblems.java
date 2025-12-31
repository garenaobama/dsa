import java.util.*;

public class GraphProblems {

    // Graph represented as an Adjacency List
    // Map: Vertex -> List of Neighbors
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        // Build Graph
        // 0 -- 1
        // | |
        // 2 -- 3 -- 4
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        addEdge(3, 4);

        System.out.println("Graph Adjacency List:");
        printGraph();

        // Test BFS
        System.out.println("\n--- BFS Starting from 0 ---");
        bfs(0); // Expected: 0 1 2 3 4 (Order may vary slightly)

        // Test Path Finding (DFS)
        System.out.println("\n\n--- Path Finding ---");
        System.out.println("Path 0 -> 4: " + hasPath(0, 4, new HashSet<>())); // true
        System.out.println("Path 0 -> 99: " + hasPath(0, 99, new HashSet<>())); // false
    }

    /**
     * Problem 1: Add Edge
     * Add an undirected edge between u and v.
     */
    public static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    /**
     * Problem 2: Breadth-First Search (BFS)
     * Print all nodes reachable from 'start' in BFS order.
     * Hint: Use a Queue and a Set for visited nodes.
     */
    public static void bfs(int start) {
        // TODO: Implement BFS
        // 1. Queue<Integer> q = ...
        // 2. Set<Integer> visited = ...
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int neighbor : graph.get(curr)) {
                if (!visited.contains(neighbor)) {
                    q.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    /**
     * Problem 3: Find Path (DFS)
     * Return true if there is a path from src to dst.
     * Hint: Recursion! If src == dst, return true. Else, check neighbors.
     */
    public static boolean hasPath(int src, int dst, Set<Integer> visited) {
        // TODO: Implement DFS
        return false;
    }

    // Helper to print graph
    public static void printGraph() {
        for (int node : graph.keySet()) {
            System.out.println(node + " -> " + graph.get(node));
        }
    }
}
