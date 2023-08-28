package task1;

import org.example.task1.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class ArrayUtilsTest {

    @Test
    void testCommon() {
        int[] numbers = {1, -2, 1, 0, 11, 2, 1, -2};
        List<Map.Entry<Integer, Integer>> result = ArrayUtils.calcCountOfNumbers(numbers);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(5, result.size());
        Assertions.assertEquals("[0=1, 2=1, 11=1, -2=2, 1=3]", result.toString());
    }

    @Test
    void testNullArray() {
        List<Map.Entry<Integer, Integer>> result = ArrayUtils.calcCountOfNumbers(null);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void testEmptyArray() {
        List<Map.Entry<Integer, Integer>> result = ArrayUtils.calcCountOfNumbers(new int[]{});
        Assertions.assertTrue(result.isEmpty());
    }
}
