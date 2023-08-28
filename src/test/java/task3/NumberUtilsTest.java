package task3;

import org.example.task3.NumberUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {

    @Test
    void testCommon() {
        int num = 100;
        int changedNum = NumberUtils.changeLastZeroToOne(num);
        Assertions.assertEquals(101, changedNum);
    }

    @Test
    void testOnlyZero() {
        int num = 0;
        int changedNum = NumberUtils.changeLastZeroToOne(num);
        Assertions.assertEquals(1, changedNum);
    }

    @Test
    void testOnlyOne() {
        int num = 1;
        int changedNum = NumberUtils.changeLastZeroToOne(num);
        Assertions.assertEquals(1, changedNum);
    }

    @Test
    void testLargeNumbers() {
        int num = 1016510110;
        int changedNum = NumberUtils.changeLastZeroToOne(num);
        Assertions.assertEquals(1016510111, changedNum);

        num = 777777;
        changedNum = NumberUtils.changeLastZeroToOne(num);
        Assertions.assertEquals(777777, changedNum);
    }
}
