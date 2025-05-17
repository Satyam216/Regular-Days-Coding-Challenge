package Day07; //problem n0. 171 leetcode
import java.util.Scanner;

class Solution {
    public static int sequenceNumber(String title){
        int result = 0;
        for(int i=0; i<title.length(); i++){
            char ch = title.charAt(i);
            int value = ch -'A' + 1;  //value of present index alphabet
            result = result * 26 + value;
        }
        return result;
    }
}

public class ExcelSheet {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        Solution ob = new Solution();
        int output  = ob.sequenceNumber(title);
        System.out.println(output);
        sc.close();
    }
}
