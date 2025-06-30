package Day54;
import java.util.Scanner;


class Solution {
    public int numSubseq(int[] nums, int target) {
        int count = 0;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                sum = nums[i] + nums[j];

                while(sum <= target){
                    count ++;
                    for(int k=j+1; k<nums.length; k++){
                        sum += nums[k];
                    }
                }
            }
        }
        return count;
    }
}

public class NumOfSubsequences {
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
        int result = ob.numSubseq(nums, k);
        System.out.println(result);
        sc.close();
        
    }
    
}
