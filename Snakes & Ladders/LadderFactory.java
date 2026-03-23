import java.util.*;

public class LadderFactory {

    public static Map<Integer, Integer> generateLadders(int n, Set<Integer> used) {
        Map<Integer, Integer> ladders = new HashMap<>();
        int cells = n * n;

        while (ladders.size() < n) {
            int start = rand(1, cells - 1);
            int end = rand(start + 1, cells);

            if (!used.contains(start) && !used.contains(end)) {
                ladders.put(start, end);
                used.add(start);
                used.add(end);
            }
        }

        return ladders;
    }

    private static int rand(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}
