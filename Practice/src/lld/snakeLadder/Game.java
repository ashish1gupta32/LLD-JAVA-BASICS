package lld.snakeLadder;


import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Game {
    private Board board;
    private Dice dice;
    Player winner;
    Deque<Player> players = new LinkedList<>();

    Game() {
        initializeGame();
    }

    private void initializeGame() {
        this.board = new Board(10, 20, 10);
        this.dice = new Dice(2);
        winner = null;
        addPlayer();
    }

    private void addPlayer() {
        players.add(new Player());
        players.add(new Player());
        players.add(new Player());
        players.add(new Player());
    }

    public void startGame() throws InterruptedException {
        System.out.println("\n................GAME STARTED ............................\n");
        while (winner == null) {
            System.out.println();
            Thread.sleep(2000L);

            Player player = pickPlayer(players);

            System.out.println(STR."Player turn is \{player.id} and current position is \{player.pos}");

            int playerNewPosition = player.pos + dice.rollDice();

            System.out.println(STR."Player \{player.id} new position is \{playerNewPosition}");

            if (playerNewPosition > board.cells.length * board.cells.length - 1) {
                winner = player;
                break;
            }
            Cell posCell = board.getCell(playerNewPosition);


            playerNewPosition = jumpCheck(posCell.jump, playerNewPosition);
            player.pos = playerNewPosition;


            if (playerNewPosition > board.cells.length * board.cells.length - 1) {
                winner = player;
                break;
            }
        }

        System.out.println(STR."\n..........Winner is \{winner.id}................");

    }

    private int jumpCheck(Jump jump, int playerNewPosition) {
        while (jump != null) {
            System.out.println(STR."Found \{jump.type}(from \{jump.start} to \{jump.end}) on player new position \{playerNewPosition}");
            playerNewPosition = jump.end;
            jump = board.getCell(playerNewPosition).jump;
        }
        return playerNewPosition;
    }

    private Player pickPlayer(Deque<Player> players) {
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }


}
