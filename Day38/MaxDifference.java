package Day38; //problem 2566. Maximum Difference by Remapping a Digit
import java.util.Scanner;

class Solution {

    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        String t = s;
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }
        t = t.replace(t.charAt(0), '0');
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}

public class MaxDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Solution ob = new Solution();
        int result = ob.minMaxDifference(n);
        System.out.println(result);
    }
    
}
