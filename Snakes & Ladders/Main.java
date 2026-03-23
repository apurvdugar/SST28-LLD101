import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter x: ");
        int x = sc.nextInt();
        System.out.print("Enter difficulty (easy or difficult): ");
        String difficulty = sc.next();
        Game game = GameFactory.createGame(n, x, difficulty);
        System.out.println("Game created with " + n + " snakes & ladders and " + x + " players in " + difficulty + " mode.");

        game.start();
        
    }
}