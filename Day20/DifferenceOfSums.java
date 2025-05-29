package Day20; //problem 2894
import java.util.Scanner;

class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for(int i=1; i<=n; i++){
            if(i % m != 0){
                num1 += i;
            }else{
                num2 += i;
            }
        }
        return num1 - num2;
    }
}
public class DifferenceOfSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        Solution ob = new Solution();
        int result  = ob.differenceOfSums(n, m);
        System.out.println(result);
        sc.close(); 
        
    }
    
}
