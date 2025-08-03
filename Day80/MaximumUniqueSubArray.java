package Day80;      //3487. Maximum Unique Subarray Sum After Deletion
import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
            if (num > 0 && !set.contains(num)) {
                sum += num;
                set.add(num);
            }
        }
        if(set.isEmpty()){
            return Arrays.stream(nums).max().getAsInt();
        }

        return sum;
    }
}
public class MaximumUniqueSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String arr[] = str.split(",");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        Solution ob = new Solution();
        int res = ob.maxSum(nums);
        System.out.println(res);   
    }
}
