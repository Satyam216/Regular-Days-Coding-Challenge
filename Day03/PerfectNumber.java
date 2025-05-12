package Day03;  //leetcode problem 507
import java.util.Scanner;

class Solution{
    public static boolean Number(int num){
        int sum = 1; 
        int limit = (int) Math.sqrt(num);
        for(int i=2; i<=limit; i++){
            if(num%i == 0){
                sum += i;
                int pairNum = num/i;
                if(pairNum != i){
                    sum += pairNum; 
                }
            }
        }
        return sum == num;
    }
}
public class PerfectNumber {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Solution ob = new Solution();
        boolean result = ob.Number(num);
        System.out.println(result);
    }
}
