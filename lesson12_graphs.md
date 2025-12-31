# Lesson 12: Graphs

## What is a Graph?
A **Graph** is a collection of nodes (called **vertices**) and connections (called **edges**).
*   **Vertex (V)**: A point in the graph (e.g., a city, a user, a webpage).
*   **Edge (E)**: A connection between two vertices (e.g., a road, a friendship, a hyperlink).

### Types of Graphs
1.  **Undirected**: Edges go both ways (A -- B). Example: Friends on Facebook.
2.  **Directed (Digraph)**: Edges have a direction (A -> B). Example: Following on Twitter.
3.  **Weighted**: Edges have a cost/weight. Example: Distance between cities.

## Representation: Adjacency List
The most common way to store a graph. We use a `Map<Integer, List<Integer>>` or `ArrayList<ArrayList<Integer>>`.
*   Index `i` stores a list of all vertices connected to vertex `i`.

```
0: [1, 2]
1: [2]
2: [0, 3]
3: []
```

## Traversals
Just like trees, we need to visit every node. To avoid infinite loops (cycles), we must use a **Visited Set**.

### 1. Breadth-First Search (BFS)
*   **Data Structure**: **Queue** (FIFO).
*   **Concept**: Explore neighbors layer by layer (like a ripple in water).
*   **Use Case**: Shortest Path in an unweighted graph.

### 2. Depth-First Search (DFS)
*   **Data Structure**: **Stack** (LIFO) or Recursion.
*   **Concept**: Go as deep as possible down one path before backtracking.
*   **Use Case**: Maze solving, Path finding, Cycle detection.

## Practice Problems

1.  **Implement Graph**: Build a graph using Adjacency List.
2.  **BFS Traversal**: Print nodes in BFS order.
3.  **Find Path**: Determine if a path exists between two nodes.
