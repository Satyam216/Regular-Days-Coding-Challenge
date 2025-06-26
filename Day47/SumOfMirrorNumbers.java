package Day47; //problem 2081. Sum of k-Mirror Numbers
import java.util.*;

class Solution {
    // Convert number to base-k string
    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    // Check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    // Generate palindromes in base-10
    private List<Long> generateBase10Palindromes(int length) {
        List<Long> palindromes = new ArrayList<>();
        int half = (length + 1) / 2;
        long start = (long) Math.pow(10, half - 1);
        long end = (long) Math.pow(10, half);

        for (long i = start; i < end; i++) {
            String firstHalf = String.valueOf(i);
            String secondHalf = new StringBuilder(firstHalf.substring(0, length % 2 == 0 ? firstHalf.length() : firstHalf.length() - 1)).reverse().toString();
            palindromes.add(Long.parseLong(firstHalf + secondHalf));
        }
        return palindromes;
    }

    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            for (long num : generateBase10Palindromes(length)) {
                if (isPalindrome(toBaseK(num, k))) {
                    sum += num;
                    count++;
                    if (count == n) break;
                }
            }
            length++;
        }

        return sum;
    }
}


public class SumOfMirrorNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Solution ob = new Solution();
        long result = ob.kMirror(n, k);
        System.out.println(result);
        sc.close();
    }
    
}
