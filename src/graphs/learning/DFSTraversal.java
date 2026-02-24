package graphs.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSTraversal {

    /**
     * Function to perform DFS traversal
     *
     * @param V     number of vertices
     * @param adj   adjacency list
     * @param start starting vertex
     * @return list containing DFS traversal order
     */
    public List<Integer> dfs(int V, List<List<Integer>> adj, int start) {

        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[V];

        dfsHelper(start, adj, visited, result);

        return result;
    }

    /**
     * Recursive helper function for DFS
     */
    private void dfsHelper(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> result) {

        // Mark current node as visited
        visited[node] = true;

        // Add to traversal result
        result.add(node);

        // Visit all unvisited neighbors
        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }

    /**
     * Performs Depth-First Search (DFS) using an explicit stack (Iterative approach)
     *
     * @param V     number of vertices in the graph
     * @param adj   adjacency list representation of the graph
     * @param start starting vertex for DFS traversal
     * @return list containing DFS traversal order
     */
    public List<Integer> dfsIterative(int V, List<List<Integer>> adj, int start) {

        // List to store the DFS traversal result
        List<Integer> result = new ArrayList<>();

        // Visited array to track which vertices have already been visited
        // Prevents infinite loops in cyclic graphs
        boolean[] visited = new boolean[V];

        // Stack used to simulate recursion
        // DFS uses LIFO (Last In First Out) order
        Stack<Integer> stack = new Stack<>();

        // Push the starting vertex onto the stack
        stack.push(start);

        // Continue traversal until stack becomes empty
        while (!stack.isEmpty()) {

            // Pop the top vertex from the stack
            int node = stack.pop();

            // Process the node only if it has not been visited yet
            if (!visited[node]) {

                // Mark the current node as visited
                visited[node] = true;

                // Add the node to the traversal result
                result.add(node);

                // Get all neighbors of the current node
                List<Integer> neighbors = adj.get(node);

                /**
                 * Push neighbors onto the stack in reverse order
                 *
                 * Reason:
                 * Stack is LIFO, so the last pushed neighbor will be processed first.
                 * By pushing in reverse order, we ensure the left-most neighbor
                 * is processed first (same behavior as recursive DFS).
                 */
                for (int i = neighbors.size() - 1; i >= 0; i--) {

                    int neighbor = neighbors.get(i);

                    // Push neighbor if it has not been visited
                    // It will be processed later
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        // Return the complete DFS traversal
        return result;
    }
}
