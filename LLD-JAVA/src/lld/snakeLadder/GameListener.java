package lld.snakeLadder;

public interface GameListener {
    void onGameStart();
    void onPlayerTurn(int playerId, int currentPos);
    void onDiceRoll(int playerId, int rolledValue);
    void onPlayerMove(int playerId, int oldPos, int newPos);
    void onJump(Type type, int startPos, int endPos);
    void onWin(int playerId);
}
