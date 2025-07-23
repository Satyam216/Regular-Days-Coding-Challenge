package Day62;  //leetcode 1353. Maximum Number of Events That Can Be Attended

import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0, day = 0, res = 0, n = events.length;

        while (i < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }
            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]);
                i++;
            }
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
                day++;
            }
        }
        return res;
    }
}
public class MaxEvents{
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
        Solution ob = new Solution();

        int result = ob.maxEvents(events);
        System.out.println(result);
    }

}

