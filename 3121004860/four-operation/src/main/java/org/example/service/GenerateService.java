package org.example.service;

import java.util.List;

public interface GenerateService {

    // 生成指定数量的题目
    List<String> generateExercises(int quantity, int range);

    // 生成单个题目
    String generateExercise(int range);


}
