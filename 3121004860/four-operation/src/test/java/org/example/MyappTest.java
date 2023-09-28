package org.example;

import org.example.service.GenerateService;
import org.example.service.impl.GenerateServiceImpl;
import org.example.util.CalculateUtils;
import org.example.util.FileUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyappTest {
    private static final GenerateService GENERATE_SERVICE = new GenerateServiceImpl();  // 生成业务对象

    @Test
    public void totalTest() {
        // 声明文件位置
        String exercisesFile = "D:\\HYHAO\\Documents\\four-operations\\four-operations\\3121004860\\four-operation\\src\\main\\resources\\Exercises.txt";
        String answersFile = "D:\\HYHAO\\Documents\\four-operations\\four-operations\\3121004860\\four-operation\\src\\main\\resources\\Answers.txt";
        String gradeFile = "D:\\HYHAO\\Documents\\four-operations\\four-operations\\3121004860\\four-operation\\src\\main\\resources\\Grade.txt";

        // 生成题目
        List<String> exercises = GENERATE_SERVICE.generateExercises(5, 5);

        // 保存题目到文件
        FileUtils.saveExercisesToFile(exercises, "D:\\HYHAO\\Documents\\four-operations\\four-operations\\3121004860\\four-operation\\src\\main\\resources\\Exercises.txt");

        // 计算答案
        List<String> answers = new ArrayList<>();
        String answer;
        for (String exercise : exercises) {
            answer = CalculateUtils.calculateAnswer(exercise);
            answers.add(answer);
        }

        // 保存答案到文件
        FileUtils.saveAnswersToFile(answers, "Answers.txt");

        // 判断答案并统计
        FileUtils.checkAnswers(exercisesFile, answersFile, gradeFile);
    }
}
