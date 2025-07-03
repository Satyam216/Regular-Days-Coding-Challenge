package Day56;  //problem 3330. Find the Original Typed String I

import java.util.Scanner;

class Solution{
    public int possibleStringCount(String str){
        int count = 1;
        int maxVariant = 0;
        int n = str.length();
        int totalPossibleString = 1;

        for(int i=1; i<n; i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else{
                if(count > 1){
                    maxVariant =  count -1;
                    totalPossibleString += maxVariant;
                }
                maxVariant = 0;
                count = 1;
            }
        }
        if(count > 1){
            maxVariant =  count -1;
            totalPossibleString += maxVariant;
        }
        return totalPossibleString;
    }
}

public class OriginalTypedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution ob = new Solution();
        int result = ob.possibleStringCount(str);
        System.out.println(result);
    }
}
