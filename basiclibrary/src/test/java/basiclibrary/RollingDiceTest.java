package basiclibrary;

import org.junit.Test;

import static org.junit.Assert.*;

public class RollingDiceTest {

    @Test
    public void rollingDiceTest_roll1Time() {
        int expectedArrayLength = 1;
        assertEquals(expectedArrayLength, RollingDice.roll(1).length);
    }

    @Test
    public void rollingDiceTest_roll4Times() {
        int expectedArrayLength = 4;
        assertEquals(expectedArrayLength, RollingDice.roll(4).length);
    }

    @Test
    public void rollingDiceTest_duplicatesTrue() {
        int[] expectedArray = new int[]{1,2,2,3};
        assertTrue("Should contain duplicates", RollingDice.containsDuplicates(expectedArray));
    }

    @Test
    public void rollingDiceTest_duplicatesFalse() {
        int[] expectedArray = new int[]{1,2,3,4};
        assertFalse("Should NOT contain duplicates", RollingDice.containsDuplicates(expectedArray));
    }

    @Test
    public void rollingDiceTest_calculateAverageSuccess() {
        int[] testArray = new int[]{1,2,3,4};
        double avg = 2.5;
        assertEquals(avg, RollingDice.calculateAverage(testArray), 0.01);
    }

    @Test
    public void rollingDiceTest_calculateAverageFail() {
        int[] testArray = new int[]{1,2,3,4};
        double avg = 5.0;
        assertNotEquals(avg, RollingDice.calculateAverage(testArray), 0.01);
    }

    @Test
    public void rollingDiceTest_calculateLowestAverageArrayOfArraysSuccess() {
        int[] expectedArray = new int[]{55, 54, 60, 53, 59, 57, 61};
        int[][] weeklyMonthTemperatures = {
            {66, 64, 58, 65, 71, 57, 60},
            {57, 65, 65, 70, 72, 65, 51},
            {55, 54, 60, 53, 59, 57, 61},
            {65, 56, 55, 52, 55, 62, 57}
        };

        assertArrayEquals(expectedArray, RollingDice.calculateAverageArrayOfArrays(weeklyMonthTemperatures));
    }

    @Test
    public void rollingDiceTest_calculateLowestAverageArrayOfArraysDifferentOrder() {
        int[] expectedArray = new int[]{55, 54, 60, 53, 59, 57, 61};
        int[][] weeklyMonthTemperatures = {
                {55, 54, 60, 53, 59, 57, 61},
                {66, 64, 58, 65, 71, 57, 60},
                {57, 65, 65, 70, 72, 65, 51},
                {65, 56, 55, 52, 55, 62, 57}
        };

        assertArrayEquals(expectedArray, RollingDice.calculateAverageArrayOfArrays(weeklyMonthTemperatures));
    }
}