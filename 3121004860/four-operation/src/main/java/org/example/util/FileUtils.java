package org.example.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
}
