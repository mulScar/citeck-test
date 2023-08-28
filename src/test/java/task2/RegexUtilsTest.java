package task2;

import org.example.task2.RegexUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RegexUtilsTest {

    @Test
    void testCommon() {
        String regex = "([][[]()])";
        boolean isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertTrue(isBalanced);

        regex = "([][]()])";
        isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertFalse(isBalanced);
    }

    @Test
    void testSimpleRegex() {
        String regex = "[0-9]+";
        boolean isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertTrue(isBalanced);

        regex = "[(0-9])[]([)]+";
        isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertFalse(isBalanced);

        regex = "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$";
        isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertTrue(isBalanced);

        regex = "^\\w+([.-?\\w+)*@\\w+((((([.-]?\\w+)((])*(\\.\\w{2,3]]})+$";
        isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertFalse(isBalanced);
    }

    @Test
    void testRegexWhichMatchBracket() {
        String regex = "[ha]+[\\)]+";
        boolean isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertTrue(isBalanced);

        regex = "[ha]+[\\)]+[";
        isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertFalse(isBalanced);

        regex = "([ha]+[\\)]+";
        isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertFalse(isBalanced);

        regex = "\\(\\[\\([^\\[\\]()]*source=([\\w.]+)";
        isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertTrue(isBalanced);
    }

    @Test
    void testInvalidRegex() {
        String regex = "";
        boolean isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertTrue(isBalanced);

        isBalanced = RegexUtils.checkRegexBalance(null);
        Assertions.assertTrue(isBalanced);

        regex = "0123456789";
        isBalanced = RegexUtils.checkRegexBalance(regex);
        Assertions.assertTrue(isBalanced);
    }
}
