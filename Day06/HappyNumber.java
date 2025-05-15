package Day06;
import java.util.HashSet;
import java.util.Scanner;

class Solution{
    public static boolean happyNum(int num){
        HashSet<Integer> seen = new HashSet<>();
        while(num !=1){
            if(seen.contains(num)){
                return false;
            }else{
                seen.add(num);
            };
            int sum =0;
            while(num > 0){
                int rem = num % 10;
                sum += (rem*rem);
                num = num / 10;
            }
            num = sum;
        }
        return num == 1;
    }
}
public class HappyNumber {
    public static void main(String args[]){
     Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Solution ob = new Solution();
        boolean ans = ob.happyNum(num);
        System.out.println(ans);
    }
}
