package Day83;    //2044. Count Number of Maximum Bitwise-OR Subsets
import java.util.Scanner;;

class Solution {
    int maxOr = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) {
            maxOr |= num;
        }
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count++;
            }
            return;
        }
        dfs(nums, index + 1, currentOr | nums[index]);
        dfs(nums, index + 1, currentOr);
    }
}

public class BitwiseORSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String arr[] = str.split(",");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        Solution ob = new Solution();
        int res = ob.countMaxOrSubsets(nums);
        System.out.println(res);
    }
}
