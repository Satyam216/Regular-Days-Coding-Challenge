package Day72;  // 3202. Find the Maximum Length of Valid Subsequence II
import java.util.Scanner;

class Solution {

    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        return res;
    }
}

public class MaximumLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String arr[] = str.split(" ");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        int k = sc.nextInt();
        Solution ob = new Solution();
        int result = ob.maximumLength(nums,k);
        System.out.println(result);
    }
    
}
