package Day53;

import java.util.Arrays;
import java.util.Scanner;

class Solution{
    public int[] maxSubsequence(int nums[], int k){
        int n = nums.length;
        int numsIndexArray[][] = new int[n][2];
        int result[] = new int[k];

        for(int i=0; i<n; i++){
            numsIndexArray[i][0] = i;
            numsIndexArray[i][1] = nums[i];
        }
        Arrays.sort(numsIndexArray, (x1,x2) -> Integer.compare(x2[1], x1[1]));
        Arrays.sort(numsIndexArray, 0, k, (x1,x2) -> Integer.compare(x1[0], x2[0]));

        for(int i=0; i<k; i++){
            result[i] = numsIndexArray[i][1];
        }
        return result;
    }
}

public class MaxSubsequenceSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String arr[] = str.split(",");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        int k = sc.nextInt();

        Solution ob = new Solution();
        int result[] = ob.maxSubsequence(nums, k);
        System.out.println(Arrays.toString(result));
        sc.close();
    }
}
