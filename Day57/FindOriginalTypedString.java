package Day57;   //problem 3333. Find the Original Typed String II

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution{
    public int possibleStringCount(String str, int k){
        List<Integer> freq = new ArrayList<Integer>();
        int count = 1;

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else{
                freq.add(count);
                count = 1;
            }
        }
        return 1;
    }
}

public class FindOriginalTypedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();

        Solution ob = new Solution();
        int result = ob.possibleStringCount(str, k);
        System.out.println(result);
    }
    
}
