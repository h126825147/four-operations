package org.example.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class FileUtils {
    private FileUtils() {
    }

    /**
     * 保存题目到文件
     *
     * @param exercises 题目集合
     * @param fileName  题目文件名称
     */
    public static void saveExercisesToFile(List<String> exercises, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < exercises.size(); i++) {
                writer.write((i + 1) + ". " + exercises.get(i) + "\n");
            }
        } catch (IOException e) {
            System.out.println("保存题目到文件失败: " + e.getMessage());
        }
    }

    /**
     * 保存答案到文件
     *
     * @param answers  答案集合
     * @param fileName 答案文件名称
     */
    public static void saveAnswersToFile(List<String> answers, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < answers.size(); i++) {
                writer.write((i + 1) + ". " + answers.get(i) + "\n");
            }
        } catch (IOException e) {
            System.out.println("保存答案到文件失败: " + e.getMessage());
        }
    }

    /**
     * 读取文件内容
     *
     * @param fileName 文件
     * @return 内容
     */
    public static List<String> readFileLines(String fileName) {
        List<String> messages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                messages.add(line);
            }
        } catch (IOException e) {
            System.out.println("读取文件失败: " + e.getMessage());
        }
        return messages;
    }

    public static void checkAnswers(String exercisesFile, String answersFile, String gradeFile) {
        List<String> exerciseLines = readFileLines(exercisesFile);
        List<String> answerLines = readFileLines(answersFile);

        int correctCount = 0; // 正确答案数量
        int wrongCount = 0; // 错误答案数量
        List<Integer> correctIndices = new ArrayList<>(); // 正确答案的题目索引
        List<Integer> wrongIndices = new ArrayList<>(); // 错误答案的题目索引

        for (int i = 0; i < answerLines.size(); i++) {
            String answer = answerLines.get(i);
            String expectedAnswer = exerciseLines.get(i).substring(0, 3) + CalculateUtils.calculateAnswer(exerciseLines.get(i).substring(3));

            if (answer.equals(expectedAnswer)) {
                correctCount++;
                correctIndices.add(i + 1);
            } else {
                wrongCount++;
                wrongIndices.add(i + 1);
            }
        }

        writeGradeToFile(correctCount, wrongCount, correctIndices, wrongIndices, gradeFile);
    }

    public static void writeGradeToFile(int correctCount, int wrongCount, List<Integer> correctIndices, List<Integer> wrongIndices, String gradeFile) {
        try (Formatter formatter = new Formatter(gradeFile)) {
            formatter.format("Correct: %d %s%n", correctCount, getIndicesString(correctCount, correctIndices));
            formatter.format("Wrong: %d %s%n", wrongCount, getIndicesString(wrongCount, wrongIndices));
        } catch (FileNotFoundException e) {
            System.out.println("写入文件时发生错误：" + e.getMessage());
        }
    }

    public static String getIndicesString(int count, List<Integer> indices) {
        StringBuilder sb = new StringBuilder("(");

        for (int i = 0; i < count; i++) {
            int index = indices.get(i);
            sb.append(index);

            if (i != count - 1) {
                sb.append(", ");
            }
        }

        sb.append(")");
        return sb.toString();
    }

}
