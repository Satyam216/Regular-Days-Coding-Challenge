package Day50;
import java.util.Scanner;

class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int count = 0;
        int zeros = 0;
        long value = 0;
        int power = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zeros++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (power < 32) { 
                    long add = 1L << power;
                    if (value + add <= k) {
                        value += add;
                        count++;
                        power++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                power++;
            }
        }
        return count + zeros;
    }
}
public class LongestBinarySubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int k = sc.nextInt();

        Solution ob = new Solution();
        int result = ob.longestSubsequence(s, k);
        System.out.println(result);   
    }
}
