package org.example.service.impl;

import org.example.service.GenerateService;
import org.example.util.ConstantUtils;
import org.example.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;


public class GenerateServiceImpl implements GenerateService {
    /**
     * 生成指定数量的题目
     *
     * @param quantity 题目数量
     * @param range    数值范围
     * @return 题目集合
     */
    @Override
    public List<String> generateExercises(int quantity, int range) {
        List<String> exercises = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            String exercise = generateExercise(range);
            exercises.add(exercise);
        }
        return exercises;
    }

    /**
     * 生成单个题目
     *
     * @param range 数值范围
     * @return 单个题目
     */
    @Override
    public String generateExercise(int range) {
        StringBuilder sb = new StringBuilder();
        int operatorCount = 0; // 当前题目中的运算符个数

        // 随机生成第一个数（自然数或真分数）
        sb.append(RandomUtils.generateNumber(range));

        while (operatorCount < ConstantUtils.MAX_OPERATORS) {
            // 随机生成运算符
            char operator = RandomUtils.generateOperator();
            sb.append(" ").append(operator).append(" ");

            // 随机生成下一个数
            sb.append(RandomUtils.generateNumber(range));

            operatorCount++;
        }

        return sb + " = ";
    }
}
