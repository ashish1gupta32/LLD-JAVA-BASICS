package lld.snakeLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    private Board board;
    private Dice dice;
    Player winner;
    Deque<Player> players = new LinkedList<>();
    private GameListener listener;

    public Game(GameListener listener) {
        this.listener = listener;
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

    public void startGame() {
        if (listener != null) listener.onGameStart();
        
        int boardSize = board.cells.length * board.cells.length;
        int maxPos = boardSize - 1;

        while (winner == null) {
            Player player = pickPlayer(players);
            
            if (listener != null) listener.onPlayerTurn(player.id, player.pos);

            int roll = dice.rollDice();
            if (listener != null) listener.onDiceRoll(player.id, roll);
            
            int playerNewPosition = player.pos + roll;

            if (playerNewPosition > maxPos) {
                winner = player;
                if (listener != null) listener.onWin(winner.id);
                break;
            }
            
            Cell posCell = board.getCell(playerNewPosition);
            int finalPosition = processJumps(posCell.jump, playerNewPosition);
            
            if (listener != null) listener.onPlayerMove(player.id, player.pos, finalPosition);

            player.pos = finalPosition;

            if (player.pos > maxPos) {
                winner = player;
                if (listener != null) listener.onWin(winner.id);
                break;
            }
        }
    }

    private int processJumps(Jump jump, int currentPos) {
        while (jump != null) {
            if (listener != null) listener.onJump(jump.type, jump.start, jump.end);
            currentPos = jump.end;
            jump = board.getCell(currentPos).jump;
        }
        return currentPos;
    }

    private Player pickPlayer(Deque<Player> players) {
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }
}
