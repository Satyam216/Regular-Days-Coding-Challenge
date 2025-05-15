package Day05;  //leetcodeProblem367

import java.util.Scanner;

class Solution{
    public static boolean squarenum(int num){
        if (num == 1) return true;

        long left = 1;
        long right = num;
        while(left <= right){
            long mid = (left+right)/2;
            long sqr = mid * mid; 
            if(sqr == num){
                return true;
            }else if(sqr < num){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}

public class PerfectSquare {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Solution ob = new Solution();
        boolean ans = ob.squarenum(num);
        System.out.println(ans);
    }
}
