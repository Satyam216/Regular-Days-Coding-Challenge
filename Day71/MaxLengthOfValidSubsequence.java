package Day71;

import java.util.Arrays;
import java.util.Scanner;

class Solution{
    public int maximumLength(int nums[]){
        int maxLength = 0;
        int length = 0;
        for(int i=0; i<nums.length;){
            int end = Math.min(i+3,nums.length);
            int subArray[] = Arrays.copyOfRange(nums,i,end);
            length = subArray.length;
            for(int j=0; j<length-1; j++){
                int compareNum = (subArray[length-2] + subArray[length - 1])%2;
                int sum = subArray[j]%2 + subArray[j+1];
                if(sum == compareNum){
                    maxLength = Math.max(length, maxLength);
                }
            }
            i = i+2;
        }
    return maxLength;
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
