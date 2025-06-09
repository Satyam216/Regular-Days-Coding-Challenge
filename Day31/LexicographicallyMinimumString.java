package Day31; //problem 3170
import java.util.*;

class Solution {
    @SuppressWarnings("unchecked")
    public String clearStars(String s) {
        Deque<Integer>[] cnt = (Deque<Integer>[]) new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            cnt[i] = new ArrayDeque<>();
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                cnt[arr[i] - 'a'].push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!cnt[j].isEmpty()) {
                        arr[cnt[j].pop()] = '*';
                        break;
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}

public class LexicographicallyMinimumString {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Solution ob = new Solution();
        String result = ob.clearStars(s);
        System.out.println(result);
    }
}
