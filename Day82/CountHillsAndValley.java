package Day82;  //2210. Count Hills and Valleys in an Array
import java.util.*;

class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> filtered = new ArrayList<>();
        filtered.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                filtered.add(nums[i]);
            }
        }
        int count = 0;
        for (int i = 1; i < filtered.size() - 1; i++) {
            int prev = filtered.get(i - 1);
            int curr = filtered.get(i);
            int next = filtered.get(i + 1);
            if ((curr > prev && curr > next) || (curr < prev && curr < next)){
                count++;
            }
        }
        return count;
    }
}


public class CountHillsAndValley {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String arr[] = str.split(",");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        Solution ob = new Solution();
        int res = ob.countHillValley(nums);
        System.out.println(res);
    }
}
