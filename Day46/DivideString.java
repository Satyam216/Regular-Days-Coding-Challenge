package Day46;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        int totalGroups = (s.length() + k - 1) / k;
        String[] result = new String[totalGroups];

        int index = 0;
        for (int i = 0; i < totalGroups; i++) {
            int end = Math.min(index + k, s.length());
            String group = s.substring(index, end);

            if (group.length() < k) {
                StringBuilder sb = new StringBuilder(group);
                while (sb.length() < k) {
                    sb.append(fill);
                }
                group = sb.toString();
            }

            result[i] = group;
            index += k;
        }

        return result;
    }
}

public class DivideString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        char ch = sc.next().charAt(0);
        
        Solution ob = new Solution();
        String result[] = ob.divideString(str, k, ch);
        System.out.println(Arrays.toString(result));
        sc.close();
    }
}
