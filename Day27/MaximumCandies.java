package Day27; //problem198

import java.util.*;

class Solution {

    public int maxCandies(
        int[] status,
        int[] candies,
        int[][] keys,
        int[][] containedBoxes,
        int[] initialBoxes
    ) {
        int n = status.length;
        boolean[] canOpen = new boolean[n];
        boolean[] hasBox = new boolean[n];
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; ++i) {
            canOpen[i] = (status[i] == 1);
        }

        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (canOpen[box]) {
                q.offer(box);
                used[box] = true;
                ans += candies[box];
            }
        }

        while (!q.isEmpty()) {
            int bigBox = q.poll();
            for (int key : keys[bigBox]) {
                canOpen[key] = true;
                if (!used[key] && hasBox[key]) {
                    q.offer(key);
                    used[key] = true;
                    ans += candies[key];
                }
            }
            for (int box : containedBoxes[bigBox]) {
                hasBox[box] = true;
                if (!used[box] && canOpen[box]) {
                    q.offer(box);
                    used[box] = true;
                    ans += candies[box];
                }
            }
        }

        return ans;
    }
}

public class MaximumCandies{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //status
        String str1 = sc.nextLine();
        String data1[] = str1.split(" ");
        int status[] = new int[data1.length];
        for(int i=0; i<data1.length; i++){
            status[i] = Integer.parseInt(data1[i]);
        }

        //candies
        String str2 = sc.nextLine();
        String data2[] = str2.split(" ");
        int candies[] = new int[data2.length];
        for(int i=0; i<data2.length; i++){
            candies[i] = Integer.parseInt(data2[i]);
        }

        //keys
        String str3 = sc.nextLine();
        String rows[] = str3.split(",");
        int keys[][] = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String columns[] = rows[i].trim().split("\\s+");
            keys[i] = new int[columns.length];
            for (int j = 0; j < columns.length; j++) {
                keys[i][j] = Integer.parseInt(columns[j]);
            }
        }

        // Contained Boxes
        String str5 = sc.nextLine();
        String row[] = str5.split(",");
        int containedBoxes[][] = new int[rows.length][];

        for (int i = 0; i < row.length; i++) {
            String columns[] = row[i].trim().split("\\s+");
            containedBoxes[i] = new int[columns.length];
            for (int j = 0; j < columns.length; j++) {
                containedBoxes[i][j] = Integer.parseInt(columns[j]);
            }
        }

        //initial boxes
        String str6 = sc.nextLine();
        String data6[] = str6.split(" ");
        int initialBoxes[] = new int[data6.length];
        for(int i=0; i<data6.length; i++){
            initialBoxes[i] = Integer.parseInt(data6[i]);
        }
        
        Solution ob = new Solution();

        int result = ob.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
        System.out.println(result);
    }
}