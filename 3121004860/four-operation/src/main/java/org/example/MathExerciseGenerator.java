package org.example;

import org.example.service.GenerateService;
import org.example.service.impl.GenerateServiceImpl;
import org.example.util.CalculateUtils;
import org.example.util.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class MathExerciseGenerator {
    private static final GenerateService GENERATE_SERVICE = new GenerateServiceImpl();  // 生成业务对象

    public static void main(String[] args) {
        // 解析命令行参数
        int quantity;
        int range;
        try {
            quantity = Integer.parseInt(args[1]);
            range = Integer.parseInt(args[3]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("参数错误，请按以下格式输入参数: Myapp.exe -n <题目数量> -r <数值范围>");
            return;
        }

        // 生成题目
        List<String> exercises = GENERATE_SERVICE.generateExercises(quantity, range);

        // 保存题目到文件
        FileUtils.saveExercisesToFile(exercises, "Exercises.txt");

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
        if (args.length >= 5 && args[4].equals("-e") && args.length >= 7 && args[6].equals("-a")) {
            String exercisesFile = args[5];
            String answersFile = args[7];
            FileUtils.checkAnswers(exercisesFile, answersFile, "Grade.txt");
        }
    }
}