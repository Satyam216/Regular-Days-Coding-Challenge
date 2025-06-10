package Day33; //problem 440
import java.util.Scanner;

class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--; 

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    private long countSteps(int n, long first, long last) {
        long steps = 0;
        while (first <= n) {
            steps += Math.min(n + 1, last) - first;
            first *= 10;
            last *= 10;
        }
        return steps;
    }
}

public class KthSmallestLexicographicalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Solution ob = new Solution();
        int result = ob.findKthNumber(n, k);
        System.out.println(result);
    }
    
}
