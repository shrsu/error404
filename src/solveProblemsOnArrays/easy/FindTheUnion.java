package solveProblemsOnArrays.easy;

import java.util.ArrayList;
import java.util.List;

public class FindTheUnion {

    public static List<Integer> unionSortedArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                addIfNotDuplicate(result, arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                addIfNotDuplicate(result, arr2[j]);
                j++;
            } else {
                addIfNotDuplicate(result, arr1[i]);
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            addIfNotDuplicate(result, arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            addIfNotDuplicate(result, arr2[j]);
            j++;
        }

        return result;
    }

    private static void addIfNotDuplicate(List<Integer> list, int value) {
        if (list.isEmpty() || list.get(list.size() - 1) != value) {
            list.add(value);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5};

        System.out.println(unionSortedArrays(arr1, arr2));
    }
}
