package recursionPatterns.tryAllOutcombos;


import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    // Checks if cell is inside maze, open, and not visited
    boolean isSafe(int x, int y, int n, int[][] maze, int[][] visited) {

        // Conditions:
        // 1. Inside bounds
        // 2. Cell must be open (maze[x][y] == 1)
        // 3. Cell must not be visited already

        return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1 && visited[x][y] == 0);
    }

    // Backtracking function to explore all paths
    void solve(int x, int y, int n, int[][] maze, int[][] visited, String path, List<String> res) {

        // Base case: destination reached
        if (x == n - 1 && y == n - 1) {
            res.add(path);
            return;
        }

        // Mark current cell visited
        visited[x][y] = 1;

        // Move Down
        if (isSafe(x + 1, y, n, maze, visited)) {
            solve(x + 1, y, n, maze, visited, path + "D", res);
        }

        // Move Left
        if (isSafe(x, y - 1, n, maze, visited)) {
            solve(x, y - 1, n, maze, visited, path + "L", res);
        }

        // Move Right
        if (isSafe(x, y + 1, n, maze, visited)) {
            solve(x, y + 1, n, maze, visited, path + "R", res);
        }

        // Move Up
        if (isSafe(x - 1, y, n, maze, visited)) {
            solve(x - 1, y, n, maze, visited, path + "U", res);
        }

        // Backtracking step:
        // Unmark cell so other paths can reuse it
        visited[x][y] = 0;
    }

    // Main function
    List<String> findPath(int[][] maze, int n) {

        List<String> res = new ArrayList<>();

        // Visited array to track used cells
        int[][] visited = new int[n][n];

        // Only start if first cell is open
        if (maze[0][0] == 1) {
            solve(0, 0, n, maze, visited, "", res);
        }

        return res;
    }
}
