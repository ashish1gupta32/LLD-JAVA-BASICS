package lld.snakeLadder;

public class Main {
    public static void main(String[] args) {
        GameListener consoleListener = new GameListener() {
            @Override
            public void onGameStart() {
                System.out.println("\n................GAME STARTED ............................\n");
            }

            @Override
            public void onPlayerTurn(int playerId, int currentPos) {
                System.out.println();
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Player turn is " + playerId + " and current position is " + currentPos);
            }

            @Override
            public void onDiceRoll(int playerId, int rolledValue) {
                // Dice roll implicit in move output
            }

            @Override
            public void onPlayerMove(int playerId, int oldPos, int newPos) {
                 System.out.println("Player " + playerId + " new position is " + newPos);
            }

            @Override
            public void onJump(Type type, int startPos, int endPos) {
                 System.out.println("Found " + type + "(from " + startPos + " to " + endPos + ")");
            }

            @Override
            public void onWin(int playerId) {
                 System.out.println("\n..........Winner is " + playerId + "................");
            }
        };

        Game game = new Game(consoleListener);
        game.startGame();
    }
}
