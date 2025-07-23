package Day70;  //leetcode 3136. Valid Word

import java.util.Scanner;

class Solution {
    public boolean isValid(String word) {
        //Second approach

        if(word.length() < 3){
            return false;
        }

        int hasVowel = 0;
        int hasConso = 0;

        for(char ch : word.toCharArray()){
            if(Character.isLetter(ch)){
                if("aeiouAEIOU".indexOf(ch) != -1){
                    hasVowel++;
                }else{
                    hasConso++;
                }
            }else if(!Character.isDigit(ch)){
                return false;
            }
        }
        return hasVowel>=1 && hasConso>=1;
    }
}

public class ValidWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution ob = new Solution();

        boolean result = ob.isValid(str);
        System.out.println(result);
    }
}
