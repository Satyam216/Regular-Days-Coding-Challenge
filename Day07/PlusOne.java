package Day07; //problem no. 66 leetcode

import java.util.Arrays;
import java.util.Scanner;

class Solution{
    public static int[] plusone(int digits[]){
     int n = digits.length;
     for(int i=n-1; i>0; i--){
        digits[i]++;

        if(digits[i] == 10){  //agr last me 10 ban rha +1 krke tab carry krne k liye
          digits[i] = 0;
        }else
          return digits;
        }

        int result[] = new int[n+1]; //agr 999 aa rha h jese to array ki length bdhane k liye new array create kiya or upr wala loop nhi chlega fir
        result[0] = 1;
        return result;
    }
}
public class PlusOne{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String nums[] = str.split(",");
        int arr[] = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            arr[i] = Integer.parseInt(nums[i]);
        }
        Solution ob = new Solution();
        int answer[] = ob.plusone(arr);
        System.out.println(Arrays.toString(answer));
        };
    }