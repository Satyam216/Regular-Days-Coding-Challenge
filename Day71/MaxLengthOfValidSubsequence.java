package Day71;  //leetcode 3201. Find the Maximum Length of Valid Subsequence I

import java.util.Scanner;

class Solution {
    public int maximumLength(int[] nums) {
        int countEven = 0;
        int countOdd = 0;
        int countAlternative = 1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] % 2 == 0){
                countEven++;
            }else{
                countOdd++;
            }
        }

        int parity = nums[0] % 2;

        for(int i=1; i<nums.length; i++){
            int currentParity = nums[i] % 2;
            if(currentParity != parity){
                countAlternative++;
                parity = currentParity;
            }
            
        }
        return Math.max(Math.max(countEven, countOdd), countAlternative);
    }
}


public class MaxLengthOfValidSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String arr[] = str.split(" ");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }

        Solution ob = new Solution();
        int result = ob.maximumLength(nums);
        System.out.println(result);
    }
    
}
