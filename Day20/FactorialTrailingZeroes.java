package Day20;
import java.util.Scanner;

    class Solution {
        public int trailingZeroes(int n) {
            int count = 0;
            while(n>0){
                n /= 5;
                count += n;
            }
            return count;
        }
    }
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution ob = new Solution();
        int count = ob.trailingZeroes(n);
        
        System.out.println(count);
        sc.close();
    }
}
