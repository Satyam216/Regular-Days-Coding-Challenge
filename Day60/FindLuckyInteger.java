package Day60; //problem 1394. Find Lucky Integer in an Array
import java.util.HashMap;
import java.util.Scanner;


class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int maxLucky = -1;

        for(int num : arr){
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }
        
        for(int value : freq.keySet()){
            if(value == freq.get(value)){
                maxLucky = Math.max(value, maxLucky);
            }
        }
        return maxLucky;
    }
}

public class FindLuckyInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String arr[] = str.split(",");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }

        Solution ob = new Solution();
        int result = ob.findLucky(nums);
        System.out.println(result);
    }
    
}
