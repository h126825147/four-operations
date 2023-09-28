package org.example.util;

import org.junit.Test;

public class CalculateUtilsTest {
    @Test
    public void calculateAnswerTest() {
        CalculateUtils.calculateAnswer("1'2/7 × 4 + 3 × 3 = ");
        CalculateUtils.calculateAnswer("5 × 8 = ");
        CalculateUtils.calculateAnswer("3 + 8 - 2'1/4 = ");
    }
}
