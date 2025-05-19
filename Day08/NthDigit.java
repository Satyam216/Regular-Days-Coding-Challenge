package Day08;
import java.util.Scanner;
class Solution {
    public int findNthDigit(int n) {
        long len = 1;
        long count = 9;
        long start = 1;

        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String number = Long.toString(start);
        return number.charAt((n - 1) % (int)len) - '0';
    }
}
public class NthDigit {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution ob = new Solution();
        int result = ob.findNthDigit(n);
        System.out.println(result);
        sc.close();
    }
    
}
