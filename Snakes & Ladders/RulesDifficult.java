public class RulesDifficult implements IRule {

    @Override
    public int makeMove(Player player, Board board, Dice dice) {
        int last_cell = board.getSize() * board.getSize();
        int currentPosition = player.getPosition();
        int six_count = 0;

        while (true) {
            int roll = dice.roll();
            System.out.println("Player " + player.getId() + " rolled a " + roll);

            if(roll == 6){
                six_count++;

                if (six_count == 3) {
                    System.out.println("Player " + player.getId() + " rolled 3 consecutive sixes! Turn lost.");
                    return currentPosition;
                }
            }

            int newPosition = currentPosition + roll;
            if (newPosition > last_cell) {
                System.out.println("Move exceeds board limit. Staying at " + player.getPosition());
                return currentPosition;
            }

            int finalPosition = board.resolvePosition(newPosition);
            if(finalPosition != newPosition) {
                if(finalPosition > newPosition) {
                    System.out.println("Player " + player.getId() + " climbed a ladder from " + newPosition + " to " + finalPosition);
                } else {
                    System.out.println("Player " + player.getId() + " got bitten by a snake from " + newPosition + " to " + finalPosition);
                }
            }

            currentPosition = finalPosition;

            if(roll != 6) {
                break;
            }
            System.out.println("Player " + player.getId() + " rolled a 6 and gets another turn!");
        }

        System.out.println("Player " + player.getId() + " moved to position " + currentPosition);
        return currentPosition;
    }
}