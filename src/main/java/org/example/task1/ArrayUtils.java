package org.example.task1;

import java.util.*;

public class ArrayUtils {

    public static List<Map.Entry<Integer, Integer>> calcCountOfNumbers(int[] array) {
        if (array == null || array.length == 0) {
            return Collections.emptyList();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.merge(i, 1, Integer::sum);
        }
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .toList();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> numbers = new ArrayList<>();
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }

            int[] array = numbers.stream()
                    .mapToInt(i -> i)
                    .toArray();
            List<Map.Entry<Integer, Integer>> result = calcCountOfNumbers(array);
            System.out.println(result);
        }
    }
}
