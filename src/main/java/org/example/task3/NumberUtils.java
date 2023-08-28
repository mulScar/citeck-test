package org.example.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberUtils {

    public static int changeLastZeroToOne(int num) {
        String strNum = String.valueOf(num);
        if (strNum.charAt(strNum.length() - 1) == '0') {
            return num ^ 1;
        }
        return num;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(reader.readLine());
            int changedNum = changeLastZeroToOne(num);
            System.out.println(changedNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}