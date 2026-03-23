import java.util.*;

public class Board {
    private final int size;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(int size) {
        this.size = size;
        HashSet<Integer> used = new HashSet<>();
        this.snakes = SnakeFactory.generateSnakes(size, used);
        this.ladders = LadderFactory.generateLadders(size, used);
    }

    public int getSize() {
        return size;
    }

    // gives the new position of the player after applying the snake or ladder rules 
    public int resolvePosition(int position) {
        if (snakes.containsKey(position))
            return snakes.get(position);
        else if (ladders.containsKey(position))
            return ladders.get(position);
        return position;
    }
}