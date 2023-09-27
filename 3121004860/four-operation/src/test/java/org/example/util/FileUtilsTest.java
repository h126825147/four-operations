package org.example.util;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtilsTest {
    @Test
    public void saveExercisesToFileTest() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "1 + 5 =", "5 * 8 =", "6 / 3 =");
        FileUtils.saveExercisesToFile(list, "D:\\HYHAO\\Documents\\four-operations\\four-operations\\3121004860\\four-operation\\src\\main\\resources\\Exercises.txt");
    }

    @Test
    public void saveAnswersToFileTest() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "6", "40", "2");
        FileUtils.saveAnswersToFile(list, "D:\\HYHAO\\Documents\\four-operations\\four-operations\\3121004860\\four-operation\\src\\main\\resources\\Answers.txt");

    }

}
