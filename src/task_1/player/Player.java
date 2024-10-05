package task_1.player;

import task_1.game_creation.GameHistory;

import java.util.List;
import java.util.UUID;

public class Player {
    private final UUID ID;
    private final String name;
    private final int ratingScore;
    private final List<GameHistory> games;

    public Player(String name, int ratingScore, List<GameHistory> games) {
        this.ID = UUID.randomUUID();
        this.name = name;
        this.ratingScore = ratingScore;
        this.games = games;
    }

    public String getName() {
        return name;
    }

    private void addGameHistory(GameHistory game){
        games.add(game);
    }

    @Override
    public String toString() {
        return "Player{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", ratingScore=" + ratingScore +
                ", games=" + games +
                '}';
    }

    public UUID getID(){
        return ID;
    }
}
