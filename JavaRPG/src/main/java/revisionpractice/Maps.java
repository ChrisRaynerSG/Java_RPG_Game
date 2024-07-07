package revisionpractice;

import com.sun.jdi.connect.Connector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maps {
    public static void main(String[] args) {
        Map<String,Integer> howManyLetters = new HashMap<>();
        String sentence = "The quick brown fox jumps over the lazy dog";
        sentence = sentence.toUpperCase();
        ArrayList<Character> sentenceTrim = new ArrayList<>();

        for(int i =0; i<sentence.length(); i++){
            if(sentence.substring(i,i+1).matches("[A-Z]+")){
                sentenceTrim.add(sentence.charAt(i));
            }
        }
        for(int i =0; i<sentenceTrim.size(); i++){
            if(howManyLetters.containsKey(sentenceTrim.get(i).toString())){
                int newValue = howManyLetters.get(sentenceTrim.get(i).toString())+1;
                howManyLetters.replace(sentenceTrim.get(i).toString(),newValue);
            }
            else{
                howManyLetters.put(sentenceTrim.get(i).toString(),1);
            }
        }
        System.out.println(howManyLetters.entrySet());
        System.out.println(getNumberOfVowels(sentence));
        System.out.println(getWordsWithTwoVowels(sentence));
    }

    public static long getNumberOfVowels(String sentence){
        return sentence.chars().filter(c -> c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U').count();
    }
    public static ArrayList<String> getWordsWithTwoVowels(String sentence){
        return Arrays.stream(sentence.split(" ")).filter(count -> getNumberOfVowels(count) == 2).collect(Collectors.toCollection(ArrayList::new));
    }
}
