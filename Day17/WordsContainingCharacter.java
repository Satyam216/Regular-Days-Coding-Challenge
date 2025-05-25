package Day17;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            if(words[i].indexOf(x) != -1){
                result.add(i);
            }
        }
        return result;
    }
}
public class WordsContainingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        String [] words = str.split(",");
        char x = sc.next().charAt(0);

        Solution ob = new Solution();
        List<Integer> result = ob.findWordsContaining(words, x);
        System.out.println(result);
    }
}
