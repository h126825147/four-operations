package org.example.service.impl;

import org.example.service.GenerateService;
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
        StringBuilder exercise = new StringBuilder();
        boolean useFraction = RandomUtils.getRandomBoolean();   // 是否使用真分数
        if (useFraction) {
            exercise.append(RandomUtils.getRandomFraction());
        } else {
            exercise.append(RandomUtils.getRandomNumber(range));
        }
        exercise.append(" ");
        exercise.append(RandomUtils.getRandomOperator());
        exercise.append(" ");
        exercise.append(RandomUtils.getRandomNumber(range));
        exercise.append(" = ");
        return exercise.toString();
    }
}
