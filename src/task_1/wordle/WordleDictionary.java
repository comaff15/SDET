package task_1.wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class WordleDictionary {
    private final HashSet<String>wordSet;

    public WordleDictionary(String fileName){
        this.wordSet = WordleDictionary.initWordSet(fileName);
    }

    private static HashSet<String> initWordSet(String fileName){
        Scanner fileNameScanner = null;

        try{
            fileNameScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashSet<String> wordSet = new HashSet<>();
        while(true){
            assert fileNameScanner != null;
            if (!fileNameScanner.hasNextLine()) break;
            wordSet.add(fileNameScanner.nextLine());
        }

        return wordSet;
    }

    public boolean containsWord(String word){
        return wordSet.contains(word);
    }

    public String getWord(){
        int getIndex = new Random().nextInt(wordSet.size());

        Iterator<String>iterator = wordSet.iterator();
        for (int i = 0; i < getIndex;i++){
            iterator.next();
        }

        return iterator.next();
    }
}
