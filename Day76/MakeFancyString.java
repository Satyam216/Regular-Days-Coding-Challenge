package Day76; //1957. Delete Characters to Make Fancy String
import java.util.Scanner;

class Solution{
    public String fancyString(String str){
        StringBuilder result = new StringBuilder();
        char prev = str.charAt(0);
        int freq = 1;
        result.append(str.charAt(0));
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == prev){
                freq++;
            }else{
                prev = str.charAt(i);
                freq = 1;
            }
            if(freq < 3){
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}

public class MakeFancyString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution ob = new Solution();
        String result = ob.fancyString(str);
        System.out.println(result);
    }
}
