package org.example.util;


public class RandomUtils {
    private RandomUtils() {
    }

    /**
     * 生成随机数字
     *
     * @param range 最大数字
     * @return 生成的数字
     */
    public static String generateNumber(int range) {
        StringBuilder sb = new StringBuilder();
        double randomNumber = Math.random() * range; // 生成0到range之间的随机数

        if (randomNumber < 1) {
            // 生成真分数
            int numerator = (int) (randomNumber * ConstantUtils.MAX_DENOMINATOR) + 1;
            int denominator = (int) (Math.random() * (ConstantUtils.MAX_DENOMINATOR - 1)) + 2;
            int integerPart = numerator / denominator;
            int remainder = numerator % denominator;

            if (integerPart > 0) {
                sb.append(integerPart).append("'");
            }

            sb.append(remainder).append("/").append(denominator);
        } else {
            // 生成自然数
            int num = (int) randomNumber;
            sb.append(num);
        }

        return sb.toString();
    }

    /**
     * 生成运算符
     *
     * @return 运算符
     */
    public static char generateOperator() {
        int random = (int) (Math.random() * 4); // 生成0到3之间的随机数
        char operator;

        switch (random) {
            case 0:
                operator = '+';
                break;
            case 1:
                operator = '-';
                break;
            case 2:
                operator = '×';
                break;
            default:
                operator = '÷';
                break;
        }

        return operator;
    }

}
