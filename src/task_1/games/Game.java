package task_1.games;

import task_1.player.Player;

import java.util.List;

public abstract class Game {
    private final String title;
    private final String genre;

    public Game(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public abstract void startGame(List<Player> players);
    protected abstract void endGame();
    protected abstract void settings();
    protected abstract void printGameInfo();

    static double getGameRating(){
        return (Math.random() * ((5 - 1) + 1));
    }
}
