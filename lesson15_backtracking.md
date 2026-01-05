# Lesson 15: Backtracking

## What is Backtracking?
Backtracking is a **systematic way to explore all possible solutions** to a problem by:
1.  **Making a choice** (add something to the current solution).
2.  **Exploring** the consequences of that choice (recursion).
3.  **Undoing the choice** (backtrack) if it doesn't lead to a valid solution.

Think of it as **DFS with the ability to undo decisions**.

## The Template Pattern

```java
void backtrack(current_state, choices) {
    // Base case: found a valid solution
    if (is_solution(current_state)) {
        result.add(new ArrayList<>(current_state));
        return;
    }
    
    // Try each possible choice
    for (choice : choices) {
        // 1. CHOOSE: Make a decision
        current_state.add(choice);
        
        // 2. EXPLORE: Recurse with the new state
        backtrack(current_state, new_choices);
        
        // 3. UNCHOOSE: Undo the decision (backtrack)
        current_state.remove(current_state.size() - 1);
    }
}
```

## When to Use Backtracking?
Use backtracking when you need to:
*   Generate **all possible combinations/permutations/subsets**.
*   Solve **constraint satisfaction problems** (Sudoku, N-Queens).
*   Find **all paths** in a maze or graph.

## Real-World Examples
1.  **Sudoku Solvers**: Try placing numbers 1-9, backtrack if invalid.
2.  **Chess Engines**: Explore possible moves, undo if they lead to checkmate.
3.  **Route Planning**: Find all valid routes given constraints (avoid tolls, highways).
4.  **Regex Engines**: Pattern matching with wildcards uses backtracking.
5.  **Compiler Parsers**: Try different grammar rules, backtrack on syntax errors.

## Common Problem Patterns

### 1. Subsets (Power Set)
Generate all possible subsets of a set.
*   **Example**: `[1,2,3]` → `[[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]`
*   **Choice**: Include or exclude each element.

### 2. Permutations
Generate all possible orderings of elements.
*   **Example**: `[1,2,3]` → `[[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]`
*   **Choice**: Pick any unused element at each position.

### 3. Combinations
Generate all ways to choose K elements from N.
*   **Example**: Choose 2 from `[1,2,3,4]` → `[[1,2], [1,3], [1,4], [2,3], [2,4], [3,4]]`
*   **Choice**: Include element and continue from next index.

## Time Complexity
Backtracking problems are often **exponential** in time complexity:
*   Subsets: **O(2^N)** - Each element has 2 choices (include/exclude).
*   Permutations: **O(N!)** - N choices for first position, N-1 for second, etc.
*   Combinations: **O(C(N,K))** - Binomial coefficient.

This is expected! We're exploring all possibilities.

## Practice Problems
1.  **Subsets**: Generate all subsets of an array.
2.  **Permutations**: Generate all permutations of an array.
