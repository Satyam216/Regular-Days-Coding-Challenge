package Day57;   //problem 3333. Find the Original Typed String II

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution{
    public int possibleStringCount(String str, int k){
        List<Integer> freq = new ArrayList<Integer>();
        int count = 1;

        if(str.length() < k){ // if given input string  length is smaller than k
            return 0;
        }

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else{
                freq.add(count);
                count = 1;
            }
        }
        freq.add(count);
        
        int p = 1; //total possible strings
        for(int value : freq){
            p *= value;
        }
        if(freq.size() > k){  // if total unique character are greater than size k so all string are possible
          return p;
        }

        return p;
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
