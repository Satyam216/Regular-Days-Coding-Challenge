package Day34; // 3443 Max difference between even and odd frequency
import java.util.Scanner;

class Solution {
    public int maxDiff(String s){
        int length = s.length();
        int[] freq = new int[26];

        int maxOddFreq = 0;
        int minEvenFreq = length+1;

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(freq[i] == 0){
                continue;
            }

            if(freq[i] % 2 == 0){ //even freq
                minEvenFreq = Math.min(minEvenFreq, freq[i]);
            }else{
                maxOddFreq = Math.max(maxOddFreq, freq[i]);
            }
        }
        return maxOddFreq - minEvenFreq;
    }
    
} 
public class MaxDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        Solution ob = new Solution();
        int result = ob.maxDiff(str);
        System.out.println(result);
    }
    
}
