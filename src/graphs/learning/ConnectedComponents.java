package graphs.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponents {

    /**
     * Function to count the number of connected components
     *
     * @param V     number of vertices
     * @param edges edge list representing undirected graph
     * @return number of connected components
     */
    public int countComponents(int V, int[][] edges) {

        // Step 1: Create adjacency list
        // adj.get(i) will store all neighbors of vertex i
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Since graph is undirected, add both directions
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: Create visited array
        boolean[] visited = new boolean[V];

        // Step 3: Variable to count connected components
        int components = 0;

        // Step 4: Traverse all vertices
        for (int i = 0; i < V; i++) {

            // If vertex is not visited, it's a new component
            if (!visited[i]) {

                // Increase component count
                components++;

                // Perform BFS starting from this vertex
                bfs(i, adj, visited);
            }
        }

        return components;
    }

    /**
     * BFS traversal to mark all vertices in the same component as visited
     *
     * @param start   starting vertex
     * @param adj     adjacency list
     * @param visited visited array
     */
    private void bfs(int start, List<List<Integer>> adj, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        // Mark start vertex as visited and add to queue
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {

            // Remove vertex from queue
            int node = queue.poll();

            // Visit all neighbors
            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
