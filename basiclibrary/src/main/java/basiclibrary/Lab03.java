package basiclibrary;

import java.util.*;

public class Lab03 {

    public static String analyzeWeatherData(int[][] weeklyMonthTemperatures) {
        // https://www.geeksforgeeks.org/hashset-in-java/
        HashSet<Integer> h = new HashSet<>();

        for (int i = 0; i < weeklyMonthTemperatures.length; i++) {
            for (int j = 0; j < weeklyMonthTemperatures[i].length; j++) {
                h.add(weeklyMonthTemperatures[i][j]);
            }
        }

        // http://www.java2s.com/Tutorial/Java/0140__Collections/FindmaximumelementofHashSet.htm
        int max = Collections.max(h);
        int min = Collections.min(h);

        // https://www.javatpoint.com/StringBuilder-class
        StringBuilder sb = new StringBuilder();

        sb.append("High: ").append(max).append(System.getProperty("line.separator"));
        sb.append("Low: ").append(min).append(System.getProperty("line.separator"));

        for (int i = min; i <= max; i++) {
            if (!h.contains(i)) {
                // https://stackoverflow.com/questions/14534767/how-to-append-a-newline-to-stringbuilder
                sb.append("Never saw temperature: ").append(i).append(System.getProperty("line.separator"));
            }
        }

        return sb.toString();
    }

    public static String tally(List<String> votes) {
        String maxName = null;
        int maxVotes = 0;

        for (String name : votes) {
            // https://www.geeksforgeeks.org/java-util-collections-frequency-java-examples/
            int v = Collections.frequency(votes, name);

            if (v > maxVotes) {
                maxVotes = v;
                maxName = name;
            }
        }

        return maxName + " received the most votes!";
    }
}
