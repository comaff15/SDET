package task_1;

import task_1.games.DiceGame;
import task_1.games.Game;
import task_1.games.WordGame;
import task_1.player.Player;
import task_1.player.PlayerRepository;
import task_1.player.PlayerRepositoryInMemory;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        PlayerRepository repository = new PlayerRepositoryInMemory();
        Map <Integer, Game> games = new LinkedHashMap<>();

        DiceGame dices = new DiceGame();
        WordGame wordle = new WordGame();
        //add wordle
        games.put(0, dices);
        games.put(1, wordle);

        while(true){
            System.out.println("Введите 1 если хотите добавить игроков\n Введите 2, если хотите выбрать игру\n Нажмите 0 для выхода");
            Scanner sc = new Scanner(System.in);
            int checkKeyValue = sc.nextInt();

            switch (checkKeyValue){
                case 1:

                    System.out.println("Введите имя игрока:");
                    String name = sc.next();
                    Player player = new Player(name, 0, new ArrayList<>());
                    repository.createPlayer(player);

                case 2:
                    System.out.println("Выберете игру:\n");
                    System.out.println(games.entrySet()
                                            .stream()
                                            .map((entry) -> String.format("%s %s", entry.getKey(), entry.getValue().getTitle()))
                                            .collect(Collectors.joining("\n"))
                    );

                    int checkGameCode = sc.nextInt();
                    if(games.containsKey(checkGameCode)){
                        games.get(checkKeyValue).startGame(repository.getAll());
                    }
                case 0:
                    return;
                default:
                    System.out.println("Ввод был сделан не правильно");
            }
        }
    }
}
