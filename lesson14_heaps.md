# Lesson 14: Heaps & Priority Queues

## What is a Heap?
A **Heap** is a special Tree-based data structure that satisfies the **Heap Property**:
*   **Max-Heap**: Parent node is always >= Children. (Root is biggest).
*   **Min-Heap**: Parent node is always <= Children. (Root is smallest).

It is almost always implemented using an **Array**, not actual Node objects!

### Complexity
| Operation | Time Complexity | Description |
| :--- | :--- | :--- |
| **Peek** | **O(1)** | Look at the top (min or max) |
| **Insert (Offer)** | **O(log N)** | Add new element and "bubble up" |
| **Remove (Poll)** | **O(log N)** | Remove top and "bubble down" |

## Why use it?
You use a Heap when you repeatedly need to know **who is the most important** (biggest/smallest/urgent) element, but you don't care about the order of the rest.

### Real-World Examples
1.  **OS Task Schedulers**: The OS needs to know which process to run next. High priority processes sit at the top of the Max-Heap.
2.  **Emergency Room Triage**: Patients are treated based on severity, not arrival time. (Severity = Priority).
3.  **Google Maps (Dijkstra's Algo)**: Finds the shortest path by always processing the "closest known intersection" next (Min-Heap).
4.  **Top K Items**: "Trending Topics" on Twitter often use heaps to keep track of the top K hashtags in real-time.

## Java Implementation
Java provides `PriorityQueue<E>`.
*   **Default**: Min-Heap (Smallest numbers comes out first).
*   **Max-Heap**: Use `Collections.reverseOrder()`.

```java
// Min-Heap (Default)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.add(10);
minHeap.add(5);
System.out.println(minHeap.poll()); // 5

// Max-Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
maxHeap.add(10);
maxHeap.add(5);
System.out.println(maxHeap.poll()); // 10
```

## Practice Problem
**Find the K-th Largest Element in an Array**.
*   *Naive*: Sort array (O(N log N)) -> pick element.
*   *Heap*: Use a Min-Heap of size K. Complexity: O(N log K).
    *   Iterate through numbers.
    *   Add to heap.
    *   If heap size > K, remove smallest.
    *   At the end, the "smallest" in the heap is actually the K-th largest of the whole set!
