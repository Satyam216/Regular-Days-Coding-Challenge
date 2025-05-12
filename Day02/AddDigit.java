import java.util.*;

class Solution {
    public static int addNumber(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}

public class AddDigit {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        int answer = Solution.addNumber(num);
        System.out.println(answer);
    }
}
