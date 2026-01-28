package stringsBasicAndMedium.mediumStringProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Max-heap based on character frequency
        PriorityQueue<Character> pq =
                new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

        pq.addAll(freq.keySet());

        // Step 3: Build result string
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            sb.append(String.valueOf(c).repeat(freq.get(c)));
        }

        return sb.toString();
    }
}

