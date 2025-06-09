package Day25; //problem 2929

import java.util.Scanner;

class Solution {

    public long distributeCandies(int n, int limit) {
        long ans = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i > 2 * limit) {
                continue;
            }
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return ans;
    }
}

public class DistributedCandy2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int limit = sc.nextInt();

        Solution ob = new Solution();
        long result = ob.distributeCandies(n, limit);
        System.out.println(result);
    }
    
}
