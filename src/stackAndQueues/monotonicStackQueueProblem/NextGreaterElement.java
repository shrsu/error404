package stackAndQueues.monotonicStackQueueProblem;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Stack to maintain decreasing order
        Stack<Integer> st = new Stack<>();

        // Map to store next greater element for each value in nums2
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums2.length;

        // Step 1: Traverse nums2 from right to left
        for (int i = n - 1; i >= 0; i--) {

            int current = nums2[i];

            // Remove all elements smaller than or equal to current
            // because they cannot be next greater for this or any left element
            while (!st.isEmpty() && st.peek() <= current) {
                st.pop();
            }

            // If stack is empty → no greater element
            if (st.isEmpty()) {
                map.put(current, -1);
            } else {
                // Top of stack is the next greater element
                map.put(current, st.peek());
            }

            // Push current element for future comparisons
            st.push(current);
        }

        // Step 2: Build result array for nums1 using the map
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}