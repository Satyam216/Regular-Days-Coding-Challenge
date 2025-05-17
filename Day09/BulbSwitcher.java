package Day09;

import java.util.Scanner;

class Solution{
    public static int switchBulb(int n){
        return (int) Math.sqrt(n);
    }
}
public class BulbSwitcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution ob = new Solution();
        int ans = ob.switchBulb(n);
        System.out.println(ans);
        sc.close();
    }
    
}
