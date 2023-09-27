package org.example.util;

import java.util.Random;

public class RandomUtils {
    private RandomUtils() {
    }

    private static final String OPERATORS = "+-*/"; // 可用的运算符
    private static final String[] FRACTIONS = {"1/2", "1/3", "2/3", "1/4", "3/4", "1'1/2", "1'1/3"}; // 可用的真分数
    private static final Random RANDOM = new Random();  // 随机数常量

    // 获取一个随机的真分数
    public static String getRandomFraction() {
        return FRACTIONS[RANDOM.nextInt(FRACTIONS.length)];
    }

    // 获取一个随机的自然数
    public static int getRandomNumber(int range) {
        return RANDOM.nextInt(range);
    }

    // 获取一个随机的运算符
    public static char getRandomOperator() {
        return OPERATORS.charAt(RANDOM.nextInt(OPERATORS.length()));
    }

    // 获取一个随机的布尔值
    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}
