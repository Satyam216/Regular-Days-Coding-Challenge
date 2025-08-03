package Day86;  //898. Bitwise ORs of Subarrays
import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        
        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);
            for (int p : prev) {
                curr.add(p | num);
            }
            result.addAll(curr);
            prev = curr;
        }
        
        return result.size();
    }
}


public class BitwiseORSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String arr[] = str.split(",");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        Solution ob = new Solution();
        int res = ob.subarrayBitwiseORs(nums);
        System.out.println(res);
    }
}
