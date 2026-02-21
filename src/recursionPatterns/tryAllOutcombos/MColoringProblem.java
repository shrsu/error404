package recursionPatterns.tryAllOutcombos;

import java.util.Arrays;

public class MColoringProblem {

    /**
     * Checks whether it is safe to assign the given color to the current node.
     *
     * @param node  Current node to color
     * @param color Array storing colors of all nodes
     * @param graph Adjacency matrix representation of graph
     * @param n     Number of nodes
     * @param col   Color to assign
     * @return true if safe, false otherwise
     */
    public static boolean isSafe(int node, int[] color, boolean[][] graph, int n, int col) {

        // Check all adjacent nodes
        for (int neighbor = 0; neighbor < n; neighbor++) {

            // If neighbor is connected and has same color → not safe
            if (graph[node][neighbor] && color[neighbor] == col) {
                return false;
            }
        }

        return true;
    }

    /**
     * Recursive function to try coloring all nodes.
     *
     * @param node  Current node index
     * @param color Color array
     * @param m     Maximum number of colors
     * @param n     Number of nodes
     * @param graph Adjacency matrix
     * @return true if coloring possible
     */
    public static boolean solve(int node, int[] color, int m, int n, boolean[][] graph) {

        // Base case: all nodes colored successfully
        if (node == n) {
            return true;
        }

        // Try all colors from 1 to m
        for (int col = 1; col <= m; col++) {

            // Check if assigning this color is safe
            if (isSafe(node, color, graph, n, col)) {

                // Assign color
                color[node] = col;

                // Recur for next node
                if (solve(node + 1, color, m, n, graph)) {
                    return true;
                }

                // Backtrack (remove color)
                color[node] = 0;
            }
        }

        // No valid color found
        return false;
    }

    /**
     * Main function to check if graph can be colored with m colors.
     *
     * @param graph Adjacency matrix
     * @param m     Maximum colors allowed
     * @param n     Number of nodes
     * @return true if possible, false otherwise
     */
    public static boolean graphColoring(boolean[][] graph, int m, int n) {

        // Color array initialized to 0 (no color)
        int[] color = new int[n];
        Arrays.fill(color, 0);

        // Start coloring from node 0
        return solve(0, color, m, n, graph);
    }

    /**
     * Example usage
     */
    public static void main(String[] args) {

        int n = 4;
        int m = 3;

        boolean[][] graph = {
                {false, true,  true,  true},
                {true,  false, true,  false},
                {true,  true,  false, true},
                {true,  false, true,  false}
        };

        boolean result = graphColoring(graph, m, n);

        System.out.println(result ? 1 : 0);
    }
}
