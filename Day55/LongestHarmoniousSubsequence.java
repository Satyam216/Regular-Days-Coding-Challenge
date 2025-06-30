package Day55;  //problem 594. Longest Harmonious Subsequence
import java.util.HashMap;
import java.util.Scanner;

class Solution{
    public int longestSubsequence(int nums[]){
        HashMap<Integer , Integer> map = new HashMap<>();
        int maxlength = 0;
        int length = 0;
        //set the values
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1); //number and its frequency
        }

        // find the keys
        for(int key : map.keySet()){
            if(map.containsKey(key + 1)){
                //for length add the frequency of the numbers which have the diff 1
                length = map.get(key) + map.get(key + 1);
            }
            maxlength = Math.max(maxlength, length);
        }
        return maxlength;
    }
}
public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String arr[] = str.split(",");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }

        Solution ob = new Solution();
        int result = ob.longestSubsequence(nums);
        System.out.println(result);
        sc.close();
    }
    
}
