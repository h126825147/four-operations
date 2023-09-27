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
        for (int i = 0; i < tokens.length; i += 2) {
            if (tokens[i].contains("'")) {
                String[] parts = tokens[i].split("[ ']+");
                int wholePart = Integer.parseInt(parts[0]);
                String[] fractionPart = parts[1].split("/");

                int numerator = wholePart * Integer.parseInt(fractionPart[1]) + Integer.parseInt(fractionPart[0]);
                int denominator = Integer.parseInt(fractionPart[1]);
                tokens[i] = String.valueOf(numerator / denominator);
            }
        }

        // 从左至右进行四则运算，不考虑运算符优先级和括号
        if (tokens[0].contains("/")) tokens[0] = "0";
        int result = Integer.parseInt(tokens[0]);
        int i = 1;
        while (i < tokens.length) {
            char operator = tokens[i].charAt(0);
            if (tokens[i + 1].contains("/")) tokens[i + 1] = "0";
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
