package org.example.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class RegexUtils {

    private static final List<Character> BRACKETS = List.of('[', ']', '(', ')');

    public static boolean checkRegexBalance(String regex) {
        if (regex == null || regex.isEmpty()) {
            return true;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        char[] charArray = regex.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int index = BRACKETS.indexOf(charArray[i]);
            if (index >= 0) {
                if (i != 0 && charArray[i - 1] == '\\') { //пропускаем экранированную скобку
                    continue;
                }

                boolean isOpenBound = index % 2 == 0;
                if (isOpenBound) {
                    stack.push(index);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    int popIndex = stack.pop();
                    if (index - 1 != popIndex) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String regex = reader.readLine();
            boolean isBalanced = checkRegexBalance(regex);
            System.out.println(isBalanced);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
