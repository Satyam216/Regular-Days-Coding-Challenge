package Day58;  //problem 3304. Find the K-th Character in String Game I
import java.util.Scanner;

class Solution{
    public char kthCharacter(int k){
        StringBuilder str = new StringBuilder("a");

        while(str.length() <= k){
            int len = str.length();
            StringBuilder temp = new StringBuilder();
            for(int i=0; i<len; i++){
                char ch = str.charAt(i);
                char next = (char)((ch - 'a' + 1) % 26 + 'a') ;
                temp.append(next);
            }
            str.append(temp);
        }
        return str.charAt(k - 1);
    }
}

public class FindTheKthCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Solution ob = new Solution();
        char result = ob.kthCharacter(k);
        System.out.println(result);
    }
}
