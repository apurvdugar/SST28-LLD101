import java.util.*;

public class GameFactory {
    
    public static Game createGame(int n, int x, String ruleType) {
        IRule rule = null;
        switch (ruleType) {
            case "easy":
                rule = new RulesEasy();
                break;
            case "difficult":
                rule = new RulesDifficult();
                break;
            default:
                rule = new RulesEasy();
        }
        Queue<Player> players = new LinkedList<Player>();
        for (int i = 1; i <= x; i++) {
            Player player = new Player();
            player.setId("P" + i);
            players.add(player);
        }
        return new Game(new Board(n), new Dice(), rule, players);
    }
}