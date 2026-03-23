import java.util.*;

public class Game {
    private final Board board;
    private final Dice dice;
    private final IRule rule;
    private final Queue<Player> players;
    private final List<Player> winners;

    private final Scanner sc = new Scanner(System.in);
    public Game(Board board, Dice dice, IRule rule, Queue<Player> players) {
        this.board = board;
        this.dice = dice;
        this.rule = rule;
        this.players = players;
        this.winners = new ArrayList<>();
    }

    public void start() {
        System.out.println("Game started with " + players.size() + " players.");
        while (players.size() > 1) {
            System.out.println("Player " + players.peek().getId() + "'s turn.");
            makeTurn();
        }
        Player last = players.poll();
        winners.add(last);

        System.out.println();
        System.out.println("Final Rankings:");
        for (int i = 0; i < winners.size(); i++) {
            System.out.println((i + 1) + ": " + winners.get(i).getId());
        }
    }

    public void makeTurn() { 
        Player player = players.poll();
        int newPosition = rule.makeMove(player, board, dice);
        player.setPosition(newPosition);
        if (player.getPosition() == board.getSize()*board.getSize()) {
            winners.add(player);
            System.out.println("Player " + player.getId() + " wins!");
        } else {
            players.add(player);
        }
    }
}