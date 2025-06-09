package Day28;  //problem 3403

import java.util.Scanner;;

class Solution {

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            String s = word.substring(i, Math.min(i + n - numFriends + 1, n));
            if (res.compareTo(s) <= 0) {
                res = s;
            }
        }
        return res;
    }
}

public class LexicographicallyLargestString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        int numFriends = sc.nextInt();

        Solution ob = new Solution();
        String result = ob.answerString(word, numFriends);
        System.out.println(result);
    }
    
}
