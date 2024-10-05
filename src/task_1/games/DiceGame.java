package task_1.games;

import task_1.dices.BrokenDice;
import task_1.dices.D20;
import task_1.dices.D6;
import task_1.dices.IDice;
import task_1.player.Player;

import java.util.*;
import java.util.stream.Collectors;

public class DiceGame extends Game {
    private static final String genre = "Arcade";
    private static final String title = "Dice game";

    private List<IDice> dices;
    private int dicesCount;
    private int ratingBet;

    private List<Player> players;
    private final HashMap<UUID, Integer> playerScore = new HashMap<>();

    public DiceGame() {
        super(title, genre);
    }

    /*     TO DO     */
    // Добавить взаимодействие с GameHistory

    @Override
    public void startGame(List<Player> players) {
        this.players = players;

        settings();
        printGameInfo();

        players.forEach((player) -> {
                    int score = dices.stream()
                            .map((IDice::roll))
                            .collect(Collectors.summingInt(Integer::intValue));

                    if (!playerScore.containsKey(player.getID())) {

                        playerScore.put(player.getID(), score);

                    } else {

                        int tmp = playerScore.get(player.getID());
                        tmp += score;

                        playerScore.put(player.getID(), tmp);
                    }

                }
        );

        endGame();
    }

    @Override
    protected void settings() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Конфигурация игры:");

        System.out.println("Введите количество костей:");

        int checkValue = sc.nextInt();
        if (checkValue <= 0 || checkValue > 4) {
            System.out.println("Слишком маленькое/большое количество костей");
        } else {
            this.dicesCount = checkValue;
        }

        for (int dice = 0; dice < dicesCount; dice++) {
            System.out.println("Выберете кость:\n 0: D20\n 1: D6");
            int getDiceName = sc.nextInt();

            if (getDiceName == 0) {
                dices.add(new D20());
            } else if (getDiceName == 1) {
                dices.add(new D6());
            } else {
                dices.add(new BrokenDice());
            }
        }

        //bet
        System.out.println("Введите ставку:");
        int checkBet = sc.nextInt();
        this.ratingBet = checkBet;
    }

    @Override
    protected void endGame() {
       Player winner = players.stream().max(Comparator.comparing((player) -> {
                    return playerScore.get(player.getID());
                }
            )
        ).get();

       System.out.println("Победил: " + winner);
      players.forEach(player -> {
         int score = playerScore.get(player.getID());
         System.out.printf("%s: %s\n", player.getName(), score);
       });
    }

    @Override
    public void printGameInfo() {
        //game title/genre
        System.out.println("Название игры: " + title +
                "Жанр игры:" + genre +
                "Ставка" + ratingBet +
                "Кости: " + dices.stream().map(IDice::getName).collect(Collectors.joining("\n")) +
                "Рэйтинг игры:" + getGameRating()
        );
    }
}