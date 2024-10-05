package task_1.games;

import task_1.player.Player;
import task_1.wordle.Wordle;
import task_1.wordle.WordleDictionary;

import java.util.List;
import java.util.Scanner;

public class WordGame extends Game{
    private static final String title = "Wordle game";
    private static final String genre = "Quiz";

    private WordleDictionary wordleDictionary;
    private Wordle wordle;
    private int worldLeght;
    private String secret;
    private static int guesses = 6;


    public WordGame() {
        super(title, genre);
    }

    @Override
    public void startGame(List<Player> players) {
        settings();
        printGameInfo();

        String guessInput = "0";
        String response = "0";

        Scanner in = new Scanner(System.in);

        while(guesses > 0){
            System.out.println("Enter your guess: ");
            guessInput = in.nextLine();
            if(isValidGuess(guessInput) == 1) {
                wordle = new Wordle(guessInput, secret, response);
                guesses--;
                if(wordle.isWinner(guessInput)){
                    break;
                }
                wordle.feedback();
                response = wordle.lastHint;

                if(guesses != 0) {
                    System.out.println("You have " + guesses + " guess(es) remaining.");
                }
            }
        }

        if(wordle.isWinner(guessInput)){
            for(int i = 0; i<secret.length(); i++){
                System.out.print("G");
            }
            System.out.println();
            System.out.println("Congratulations! You have guessed the word correctly.");
        }
        else{
            endGame();
        }


    }

    @Override
    protected void endGame() {
        System.out.println("You have run out of guesses.");
        System.out.println("The correct word was " + "\""+secret+"\".");
    }

    @Override
    protected void settings() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите длину слова от 5 до 10");
        this.worldLeght = sc.nextInt();
        if (worldLeght < 5 || worldLeght > 10){
            System.out.println("Введенная длинна выходит за разрешенные рамки\n Наказанием за тупость, будет максимальная сложность");
            wordleDictionary = new WordleDictionary("wordle_misc/10length.txt");
            this.worldLeght = 10;
        }else{
            wordleDictionary = new WordleDictionary("wordle_misc/"+worldLeght+"length.txt");
        }
        this.secret = wordleDictionary.getWord();
    }

    @Override
    protected void printGameInfo() {
        System.out.println("Название игры: " + title +
                "Жанр игры:" + genre +
                "Длинна слова" + worldLeght +
                "Количество попыток: " + guesses +
                "Рэйтинг игры:" + getGameRating()
        );
    }

    public int isValidGuess(String guess){
        if (guess.length() != worldLeght ){
            System.out.println("This word has an incorrect length. Please try again.");
            return -1;
        }
        else if(!wordleDictionary.containsWord(guess)){
            System.out.println("This word is not in the dictionary. Please try again.");
            return -1;
        }
        else{
            return 1;   //1 means the user input is valid
        }
    }

}
