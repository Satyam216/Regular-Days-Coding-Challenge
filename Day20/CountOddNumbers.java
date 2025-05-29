package Day20;  //problem 1523
import java.util.Scanner;

class Solution {
    public int countOdds(int low, int high) {
        return (high+1)/2 - low/2 ;
    }
}
public class CountOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        Solution ob = new Solution();
        int countOdd = ob.countOdds(low, high);
        System.out.println(countOdd);
        sc.close();
    }
}
