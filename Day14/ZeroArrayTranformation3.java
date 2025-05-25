package Day14;  //problem 3362

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Solution {
  public int maxRemoval(int[] nums, int[][] queries) {
    int queryIndex = 0;
    Queue<Integer> available = new PriorityQueue<>(Collections.reverseOrder()); 
    Queue<Integer> running = new PriorityQueue<>();                             

    Arrays.sort(queries, Comparator.comparingInt((int[] query) -> query[0]));

    for (int i = 0; i < nums.length; ++i) {
      while (queryIndex < queries.length && queries[queryIndex][0] <= i)
        available.offer(queries[queryIndex++][1]);
      while (!running.isEmpty() && running.peek() < i)
        running.poll();
      while (nums[i] > running.size()) {
        if (available.isEmpty() || available.peek() < i)
          return -1;
        running.offer(available.poll());
      }
    }

    return available.size();
  }
}
public class ZeroArrayTranformation3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1D array
        String str = sc.nextLine();
        String data[] = str.split(",");
        int nums[] = new int[data.length];
        for(int i=0; i<data.length; i++){
            nums[i] = Integer.parseInt(data[i]);
        }

        //2D array (querries)
        String input = sc.nextLine();
        String[] rows = input.split(",");

        int[][] querries = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] cols = rows[i].split("\\s+");
            querries[i] = new int[cols.length];
            for (int j = 0; j < cols.length; j++) {
                querries[i][j] = Integer.parseInt(cols[j]);
            }
        }
        Solution ob = new Solution();
        int result = ob.maxRemoval(nums,querries);
        System.out.println(result);
    }   
}
