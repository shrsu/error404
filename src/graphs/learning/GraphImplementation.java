package graphs.learning;

import java.util.ArrayList;

// Simple Graph Class
public class GraphImplementation {

    int n; // number of nodes
    // Adjacency Matrix
    int[][] matrix;
    // Adjacency List (unweighted)
    ArrayList<Integer>[] list;
    // Weighted Adjacency List
    ArrayList<Pair>[] weightedList;
    // Pair class for weighted graph
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // Constructor
    GraphImplementation(int n) {
        this.n = n;
        // Matrix initialization
        matrix = new int[n + 1][n + 1];
        // List initialization
        list = new ArrayList[n + 1];
        weightedList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
            weightedList[i] = new ArrayList<>();
        }
    }

    // Add edge (Unweighted Undirected)
    void addEdge(int u, int v) {
        // Matrix
        matrix[u][v] = 1;
        matrix[v][u] = 1;
        // List
        list[u].add(v);
        list[v].add(u);
    }

    // Add edge (Unweighted Directed)
    void addDirectedEdge(int u, int v) {
        matrix[u][v] = 1;
        list[u].add(v);
    }

    // Add edge (Weighted Undirected)
    void addWeightedEdge(int u, int v, int w) {
        weightedList[u].add(new Pair(v, w));
        weightedList[v].add(new Pair(u, w));
    }

    // Add edge (Weighted Directed)
    void addWeightedDirectedEdge(int u, int v, int w) {
        weightedList[u].add(new Pair(v, w));
    }

    // Print Matrix
    void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Print Adjacency List
    void printList() {
        System.out.println("Adjacency List:");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (int node : list[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    // Print Weighted List
    void printWeightedList() {
        System.out.println("Weighted Adjacency List:");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (Pair p : weightedList[i]) {
                System.out.print("(" + p.node + "," + p.weight + ") ");
            }
            System.out.println();
        }
    }

}
