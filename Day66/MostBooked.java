package Day66;   //leetcode 2402. Meeting Rooms III
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] roomAvailabilityTime = new long[n];
        int[] meetingCount = new int[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            long minRoomAvailabilityTime = Long.MAX_VALUE;
            int minAvailableTimeRoom = 0;
            boolean foundUnusedRoom = false;

            for (int i = 0; i < n; i++) {
                if (roomAvailabilityTime[i] <= start) {
                    foundUnusedRoom = true;
                    meetingCount[i]++;
                    roomAvailabilityTime[i] = end;
                    break;
                }

                if (minRoomAvailabilityTime > roomAvailabilityTime[i]) {
                    minRoomAvailabilityTime = roomAvailabilityTime[i];
                    minAvailableTimeRoom = i;
                }
            }

            if (!foundUnusedRoom) {
                roomAvailabilityTime[minAvailableTimeRoom] += end - start;
                meetingCount[minAvailableTimeRoom]++;
            }
        }

        int maxMeetingCount = 0, maxMeetingCountRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetingCount) {
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }

        return maxMeetingCountRoom;
    }
}

public class MostBooked {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String rows[] = str.split(",");
        int meetings[][] = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String columns[] = rows[i].trim().split("\\s+");
            meetings[i] = new int[columns.length];
            for (int j = 0; j < columns.length; j++) {
                meetings[i][j] = Integer.parseInt(columns[j]);
            }
        }
        int n = sc.nextInt();
        Solution ob = new Solution();

        int result = ob.mostBooked(n,meetings);
        System.out.println(result);
    }
    
}
