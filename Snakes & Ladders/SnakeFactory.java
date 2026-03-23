import java.util.*;

public class SnakeFactory {

    public static Map<Integer, Integer> generateSnakes(int n, Set<Integer> used) {
        Map<Integer, Integer> snakes = new HashMap<>();
        int cells = n * n;

        while (snakes.size() < n) {
            int head = rand(2, cells - 1);
            int tail = rand(1, head - 1);

            if (!used.contains(head) && !used.contains(tail)) {
                snakes.put(head, tail);
                used.add(head);
                used.add(tail);
            }
        }

        return snakes;
    }

    private static int rand(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}
