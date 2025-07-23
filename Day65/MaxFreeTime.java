package Day65; //leetcode 3440. Reschedule Meetings for Maximum Free Time II

import java.util.Scanner;

class Solution {

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        boolean[] q = new boolean[n];
        for (int i = 0, t1 = 0, t2 = 0; i < n; i++) {
            if (endTime[i] - startTime[i] <= t1) {
                q[i] = true;
            }
            t1 = Math.max(t1, startTime[i] - (i == 0 ? 0 : endTime[i - 1]));

            if (endTime[n - i - 1] - startTime[n - i - 1] <= t2) {
                q[n - i - 1] = true;
            }
            t2 = Math.max(
                t2,
                (i == 0 ? eventTime : startTime[n - i]) - endTime[n - i - 1]
            );
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 0 : endTime[i - 1];
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            if (q[i]) {
                res = Math.max(res, right - left);
            } else {
                res = Math.max(res, right - left - (endTime[i] - startTime[i]));
            }
        }
        return res;
    }
}
public class MaxFreeTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        int eventTime = sc.nextInt();

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
        int result = ob.maxFreeTime(eventTime, start, end);
        System.out.println(result);
    }
}
