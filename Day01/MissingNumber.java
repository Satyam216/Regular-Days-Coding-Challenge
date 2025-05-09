import java.util.Scanner;

class Solution{
    public int Number(int nums[]){
        int missingnum;
        int n  = nums.length;  //length of the array(Range)
        int actualsum = 0;

        int expectedSum = n * (n+1) / 2; //this is the sum of n posiotive numbers

        for(int i=0; i<n; i++){
            actualsum += nums[i];
        }
        missingnum = expectedSum - actualsum; //subtract the giving numbers sum from toal n numbers of sum for finding the missing number

        return missingnum;
    }
}

public class MissingNumber {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strarray = str.split(" ");
        int nums[] = new int[strarray.length];
        
        for(int i=0; i<strarray.length; i++){
            nums[i] = Integer.parseInt(strarray[i]);
        }
        Solution ob = new Solution();
        int answer = ob.Number(nums);
        System.out.println(answer);
        
    }
}
