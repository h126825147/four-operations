package org.example.util;

public class CalculateUtils {
    private CalculateUtils() {
    }

    /**
     * 计算结果
     * @param exercise 表达式
     * @return 结果
     */
    public static String calculateAnswer(String exercise) {
        String expression = exercise.substring(0, exercise.indexOf(" ="));
        String[] tokens = expression.split(" ");

        // 将问题中的真分数转换为假分数形式
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].contains("/")) {
/*
                // 解析真分数
                String[] fraction = tokens[i].split("[ ']+");
                int integerPart = Integer.parseInt(fraction[0]);
                int numerator = Integer.parseInt(fraction[1]);
                int denominator = Integer.parseInt(fraction[2]);
                if (numerator < denominator) continue;
                // 转换为假分数形式
                int convertedNum = integerPart * denominator + numerator;
                tokens[i] = String.valueOf(convertedNum);
*/
                String[] parts = tokens[i].split("[ ']+");
                int wholePart = Integer.parseInt(parts[0]);
                String[] fractionPart = parts[1].split("/");

                int numerator = wholePart * Integer.parseInt(fractionPart[1]) + Integer.parseInt(fractionPart[0]);
                int denominator = Integer.parseInt(fractionPart[1]);
                tokens[i] = String.valueOf(numerator / denominator);
            }
        }

        // 从左至右进行四则运算，不考虑运算符优先级和括号
        int result = Integer.parseInt(tokens[0]);
        int i = 1;
        while (i < tokens.length) {
            char operator = tokens[i].charAt(0);
            int operand = Integer.parseInt(tokens[i + 1]);

            switch (operator) {
                case '+':
                    result += operand;
                    break;
                case '-':
                    result -= operand;
                    break;
                case '×':
                    result *= operand;
                    break;
                case '÷':
                    result /= operand;
                    break;
                default: break;
            }

            i += 2;
        }

        return String.valueOf(result);
    }
}
