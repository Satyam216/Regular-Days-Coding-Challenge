package Day45; //problem 3085. Minimum Deletions to Make String K-Special
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class Solution {

    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char ch : word.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }
        int res = word.length();
        for (int a : cnt.values()) {
            int deleted = 0;
            for (int b : cnt.values()) {
                if (a > b) {
                    deleted += b;
                } else if (b > a + k) {
                    deleted += b - (a + k);
                }
            }
            res = Math.min(res, deleted);
        }
        return res;
    }
}

public class MinimumDeletion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int k = sc.nextInt();
        Solution ob = new Solution();
        int result = ob.minimumDeletions(word, k);
        System.out.println(result);
        sc.close();
    }
}
