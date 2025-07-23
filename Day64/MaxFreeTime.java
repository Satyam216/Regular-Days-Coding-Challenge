package Day64; //leetcode 3439. Reschedule Meetings for Maximum Free Time I
import java.util.*;

class Solution {
    public int maxFreeTime(
        int eventTime,
        int k,
        int[] startTime,
        int[] endTime
    ) {
        int n = startTime.length;
        int res = 0;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + endTime[i] - startTime[i];
        }
        for (int i = k - 1; i < n; i++) {
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            int left = i == k - 1 ? 0 : endTime[i - k];
            res = Math.max(res, right - left - (sum[i + 1] - sum[i - k + 1]));
        }
        return res;
    }
}


public class MaxFreeTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        int eventTime = sc.nextInt();
        int k = sc.nextInt();

        String str1 = sc.nextLine();
        String nums1[] = str1.split(",");
        int start[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            start[i] = Integer.parseInt(nums1[i]);
        }

        String str2 = sc.nextLine();
        String nums2[] = str2.split(",");
        int end[] = new int[nums2.length];
        for(int i=0; i<nums2.length; i++){
            end[i] = Integer.parseInt(nums2[i]);
        }


        Solution ob = new Solution();
        int result = ob.maxFreeTime(eventTime, k, start, end);
        System.out.println(result);
    }
    
}
