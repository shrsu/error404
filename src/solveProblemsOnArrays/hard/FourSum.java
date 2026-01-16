package solveProblemsOnArrays.hard;

import java.util.*;

public class FourSum {

    // Finds all unique quadruplets using hashing
    public List<List<Integer>> fourSumBetterSolution(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> result = new HashSet<>();

        // Pick the first number
        for (int i = 0; i < n; i++) {

            // Pick the second number
            for (int j = i + 1; j < n; j++) {

                // Stores numbers between j and k
                Set<Integer> seen = new HashSet<>();

                // Pick the third number
                for (int k = j + 1; k < n; k++) {

                    // Calculate required fourth number
                    long required = (long) target - arr[i] - arr[j] - arr[k];

                    // If found, we have a valid quadruplet
                    if (seen.contains((int) required)) {
                        List<Integer> quad = Arrays.asList(
                                arr[i], arr[j], arr[k], (int) required
                        );
                        Collections.sort(quad);
                        result.add(quad);
                    }

                    // Add current third number to the set
                    seen.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    // Finds all unique quadruplets using sorting + two pointers
    public List<List<Integer>> fourSumOptimalSolution(int[] arr, int target) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Fix the first number
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            // Step 3: Fix the second number
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                // Step 4: Two-pointer approach
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) arr[i] + arr[j]
                            + arr[left] + arr[right];

                    if (sum == target) {
                        result.add(Arrays.asList(
                                arr[i], arr[j], arr[left], arr[right]
                        ));

                        // Skip duplicate third numbers
                        while (left < right && arr[left] == arr[left + 1]) left++;
                        // Skip duplicate fourth numbers
                        while (left < right && arr[right] == arr[right - 1]) right--;

                        left++;
                        right--;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}

