package Day40;
import java.util.Scanner;

class Solution {
    public int maximumDifference(int[] nums) {
        int minNum = nums[0];
        int maxDiff = -1;
        int actualDiff = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > minNum){
                actualDiff = nums[i] - minNum;
                maxDiff = Math.max(maxDiff, actualDiff);
            }else{
                minNum = nums[i];
            }
        }

        return maxDiff;
    }
}

public class MaxDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        String numbers[] = str.split(",");

        int nums[] = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.parseInt(numbers[i]);
        }

        Solution ob = new Solution();
        int result = ob.maximumDifference(nums);
        System.out.println(result);
    }
}
