package task_1.game_creation;

public class GameHistory {
    private final String gameName;
    private final int playerScore;
    private final boolean isWinner;

    public GameHistory(String gameName, int playerScore, boolean isWinner) {
        this.gameName = gameName;
        this.playerScore = playerScore;
        this.isWinner = isWinner;
    }

    public String getGameName() {
        return gameName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public boolean isWinner() {
        return isWinner;
    }
}