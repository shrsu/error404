package graphs.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {

    /**
     * Function to perform BFS traversal starting from source vertex
     *
     * @param V     number of vertices
     * @param adj   adjacency list
     * @param start starting vertex
     * @return list containing BFS traversal order
     */
    public List<Integer> bfs(int V, List<List<Integer>> adj, int start) {

        // Result list to store traversal order
        List<Integer> result = new ArrayList<>();

        // Visited array to track visited vertices
        boolean[] visited = new boolean[V];

        // Queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();

        // Step 1: Mark start as visited and add to queue
        visited[start] = true;
        queue.offer(start);

        // Step 2: BFS traversal
        while (!queue.isEmpty()) {

            // Remove front vertex
            int node = queue.poll();

            // Add to result
            result.add(node);

            // Visit all neighbors
            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {

                    // Mark neighbor as visited
                    visited[neighbor] = true;

                    // Add neighbor to queue
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }

}
