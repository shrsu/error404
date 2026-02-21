package recursionPatterns.tryAllOutcombos;

import java.util.Arrays;

public class MColoringProblem {

    /**
     * Builds the adjacency matrix representation of the graph.
     *
     * @param n     Number of nodes (vertices) in the graph
     * @param edges Edge list where each edge connects two vertices
     * @return Adjacency matrix graph[n][n]
     * <p>
     * graph[u][v] = true means there is an edge between u and v
     */
    public static boolean[][] buildGraph(int n, int[][] edges) {

        // Create empty adjacency matrix initialized to false
        boolean[][] graph = new boolean[n][n];

        // Iterate through each edge
        for (int[] edge : edges) {

            int u = edge[0]; // first vertex
            int v = edge[1]; // second vertex

            // Since graph is undirected, mark both directions
            graph[u][v] = true;
            graph[v][u] = true;
        }

        return graph;
    }


    /**
     * Checks whether it is safe to assign a given color to a node.
     *
     * @param node  Current node to color
     * @param color Array storing color assigned to each node
     * @param graph Adjacency matrix
     * @param n     Number of nodes
     * @param col   Color we want to assign
     * @return true if safe, false otherwise
     * <p>
     * Condition:
     * A node can be assigned a color only if NONE of its neighbors have the same color.
     */
    public static boolean isSafe(int node, int[] color, boolean[][] graph, int n, int col) {

        // Check all neighbors
        for (int neighbor = 0; neighbor < n; neighbor++) {

            // If neighbor exists AND has same color -> not safe
            if (graph[node][neighbor] && color[neighbor] == col)
                return false;
        }

        // Safe to assign color
        return true;
    }


    /**
     * Backtracking function to assign colors to nodes.
     *
     * @param node  Current node index
     * @param color Color array
     * @param m     Number of available colors
     * @param n     Total number of nodes
     * @param graph Adjacency matrix
     * @return true if valid coloring possible, false otherwise
     * <p>
     * Approach:
     * Try assigning every color from 1 to m.
     * If safe → assign and recurse to next node.
     * If fails → backtrack.
     */
    public static boolean solve(int node, int[] color, int m, int n, boolean[][] graph) {

        // Base case: all nodes colored successfully
        if (node == n)
            return true;


        // Try all possible colors
        for (int col = 1; col <= m; col++) {

            // Check if color assignment is valid
            if (isSafe(node, color, graph, n, col)) {

                // Assign color
                color[node] = col;

                // Recurse for next node
                if (solve(node + 1, color, m, n, graph))
                    return true;

                // Backtrack: remove assigned color
                color[node] = 0;
            }
        }

        // No valid color assignment possible for this node
        return false;
    }


    /**
     * Main function to check if graph can be colored using m colors.
     *
     * @param n     Number of nodes
     * @param m     Number of colors
     * @param edges Edge list
     * @return 1 if coloring possible, 0 otherwise
     * <p>
     * Steps:
     * 1. Build adjacency matrix
     * 2. Create color array initialized to 0 (no color)
     * 3. Run backtracking from node 0
     */
    public static int graphColoring(int n, int m, int[][] edges) {

        // Step 1: Build graph
        boolean[][] graph = buildGraph(n, edges);

        // Step 2: Initialize color array
        int[] color = new int[n];

        Arrays.fill(color, 0); // 0 means no color assigned

        // Step 3: Start backtracking
        if (solve(0, color, m, n, graph))
            return 1;

        // If coloring not possible
        return 0;
    }
}
