package Day47;

import java.util.Arrays;
import java.util.Scanner;

class Solution{
    public String[] sumOfNumbers(int n, int k){
        String binaryArray[] = new String[30];
        String ans[] = new String[n];
        String binary = "";
        for(int i=1; i<30; i++){
            while(i>0){
            binary = i%k + binary;
            i = i/k;
            }
            binaryArray[i] = binary;
        }
        for(int i=0; i<30; i++){
            String reversed = new StringBuilder(binaryArray[i]).reverse().toString();
            if(binaryArray[i] == reversed){
                ans[i] = binaryArray[i];
            }
        }
        //for(int i=0; i<binaryArray)
        return ans;
    }
}

public class SumOfMirrorNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Solution ob = new Solution();
        String result[] = ob.sumOfNumbers(n, k);
        System.out.println(Arrays.toString(result));
        sc.close();
    }
    
}
