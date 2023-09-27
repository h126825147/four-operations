package org.example.service.impl;

import org.example.service.GenerateService;
import org.junit.Test;

import java.util.List;

public class GenerateServiceImplTest {
    private final GenerateService generateService = new GenerateServiceImpl();
    @Test
    public void generateExerciseTest() {
        String exercise = generateService.generateExercise(10);
        System.out.println(exercise);
    }

    @Test
    public void generateExercisesTest() {
        List<String> exercises = generateService.generateExercises(5, 10);
        for (String exercise : exercises) {
            System.out.println(exercise);
        }
    }
}
