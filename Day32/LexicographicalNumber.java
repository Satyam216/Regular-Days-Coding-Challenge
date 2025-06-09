package Day32;  //problem 386
import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
         List<Integer> result = new ArrayList<>();
        int curr = 1;
        
        for (int i = 0; i < n; i++) {
            result.add(curr);
            
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                if (curr >= n) curr /= 10;
                curr++;
                while (curr % 10 == 0) curr /= 10;
            }
        }
        
        return result;
    }
}

public class LexicographicalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        Solution ob = new Solution();
        List<Integer> result = ob.lexicalOrder(number);
        System.out.println(result);
    }
}
