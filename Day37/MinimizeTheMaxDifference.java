package Day37;  // problem 2616. Minimize the Maximum Difference of Pairs
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormPairs(nums, p, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i += 2; 
            } else {
                i++;
            }
            if (count >= p) return true;
        }
        return count >= p;
    }
}

public class MinimizeTheMaxDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        String numbers[] = str.split(",");

        int nums[] = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.parseInt(numbers[i]);
        }

        int p = sc.nextInt();

        Solution ob = new Solution();
        int result = ob.minimizeMax(nums , p);
        System.out.println(result);
    }
}
