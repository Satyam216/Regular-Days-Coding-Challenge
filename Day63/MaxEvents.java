package Day63;  //leetcode 1751. Maximum Number of Events That Can Be Attended II
import java.util.*;


class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        
        dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return dfs(0, k, events);
    }    
    
    private int[][] dp;
    private int dfs(int curIndex, int count, int[][] events) {
        if (count == 0 || curIndex == events.length) {
            return 0;
        }
        if (dp[count][curIndex] != -1) {
            return dp[count][curIndex];
        }
        int nextIndex = bisectRight(events, events[curIndex][1]);
        dp[count][curIndex] = Math.max(dfs(curIndex + 1, count, events), events[curIndex][2] + dfs(nextIndex, count - 1, events));
        return dp[count][curIndex];
    }
    
    public static int bisectRight(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }   
}
public class MaxEvents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String rows[] = str.split(",");
        int events[][] = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String columns[] = rows[i].trim().split("\\s+");
            events[i] = new int[columns.length];
            for (int j = 0; j < columns.length; j++) {
                events[i][j] = Integer.parseInt(columns[j]);
            }
        }
        int k = sc.nextInt();
        Solution ob = new Solution();

        int result = ob.maxValue(events,k);
        System.out.println(result);
    }
}
