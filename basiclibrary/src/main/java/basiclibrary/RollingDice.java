package basiclibrary;

public class RollingDice {

    // roll
    // accepts an integer n and rolls a six-sided dice n times.
    // The method should return an array containing the values of the rolls.
    public static int[] roll(int n) {
        int[] rolls = new int[n];

        for (int i = 0; i < n; i++) {
            int rand = (int)(Math.random() * 6 + 1);
            rolls[i] = rand;
        }

        return rolls;
    }

    // containsDuplicates
    // returns true or false depending on whether the array contains duplicate values.
    public static boolean containsDuplicates(int[] arr) {
        boolean duplicate = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) {
                    duplicate = true;
                    break;
                }
            }
        }

        return duplicate;
    }

    // calculateAverage
    // accepts an array of integers and calculates and returns the average of all the values in the array.
    public static double calculateAverage(int[] arr) {
        double avg = 0;

        for (int i = 0; i < arr.length; i++) {
            avg += arr[i];
        }

        return (double)(avg / arr.length);
    }

    // calculateAverageArrayOfArrays
    // Given an array of arrays calculate the average value for each array and return the array with the lowest average.
    public static double calculateAverageArrayOfArrays(int[][] arr) {
        double avg = 0;
        double count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                avg += arr[i][j];
                count++;
            }
        }

        return (double)(avg / count);
    }
}
