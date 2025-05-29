package Day19; //problem 2131

import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
         HashMap<String, Integer> map = new HashMap<>();
        int length = 0;
        boolean centralPalindromicUsed = false;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (map.getOrDefault(reversed, 0) > 0) {
                length += 4;
                map.put(reversed, map.get(reversed) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                length += 2;
                break;
            }
        }
        return length;
    }
}

public class LongestPalindrome{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        String words[] = str.split(",");

        Solution ob = new Solution();
        int count = ob.longestPalindrome(words);
        System.out.println(count);
    }
}