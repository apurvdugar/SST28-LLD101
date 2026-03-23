public class Dice {
    private static final int sides = 6;

    public int roll() {
        return (int)(Math.random() * sides) + 1;
    }
}