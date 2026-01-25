package binarySearch.bsOnAnswers;

import java.util.ArrayList;
import java.util.Collections;

public class BookAllocationProblem {

    /**
     * Given a maximum pages limit 'maxPages', compute how many students are
     * needed if each student can be assigned contiguous books and the sum
     * of pages for a student must not exceed maxPages.
     */
    public static int countStudents(ArrayList<Integer> arr, long maxPages) {
        int students = 1;           // at least one student
        long currentSum = 0L;       // pages assigned to current student

        for (int pages : arr) {
            // If adding this book does not exceed maxPages, assign to current student
            if (currentSum + pages <= maxPages) {
                currentSum += pages;
            } else {
                // Otherwise, allocate to next student
                students++;
                currentSum = pages;
            }
        }
        return students;
    }

    /**
     * Returns the minimum possible value of the maximum pages assigned to any student.
     * If allocation is impossible (m > n) returns -1.
     */
    public static long findPages(ArrayList<Integer> arr, int n, int m) {
        // if there are fewer books than students, allocation is impossible
        if (m > n) return -1;

        long low = Collections.max(arr);                 // largest single book
        long high = arr.stream().mapToLong(Integer::longValue).sum(); // sum of all pages
        long answer = high;

        // Binary search on the maximum pages per student
        while (low <= high) {
            long mid = low + (high - low) / 2;
            int requiredStudents = countStudents(arr, mid);

            if (requiredStudents > m) {
                // Need more students than allowed -> increase allowed pages
                low = mid + 1;
            } else {
                // Allocation possible with 'mid' -> try smaller maximum
                answer = mid;
                high = mid - 1;
            }
        }

        return answer;
    }
}
