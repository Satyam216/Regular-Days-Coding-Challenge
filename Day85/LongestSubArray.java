package Day85;  // 2419. Longest Subarray With Maximum Bitwise AND
import java.util.Scanner;

class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0; 
        for(int num :  nums){
            max = Math.max(num, max);
        }
        int count = 1;
        int maxLength = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == max && nums[i] == nums[i+1]){
                count++;
            }else{
                maxLength = Math.max(maxLength, count);
                count = 1;
            }
        }
        return Math.max(maxLength, count);
    }
}

public class LongestSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String arr[] = str.split(",");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        Solution ob = new Solution();
        int res = ob.longestSubarray(nums);
        System.out.println(res);
    }
}
