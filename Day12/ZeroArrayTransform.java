package Day12;

import java.util.Scanner;

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            diff[l]++;
            if (r + 1 < n) {
                diff[r + 1]--;
            }
        }
        
        int[] coverage = new int[n];
        int current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            coverage[i] = current;
        }
        
        for (int i = 0; i < n; i++) {
            if (coverage[i] < nums[i]) {
                return false;
            }
        }
        
        return true;
    }
}
public class ZeroArrayTransform {
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
        boolean result = ob.isZeroArray(nums,querries);
        System.out.println(result);
    }
    
}
