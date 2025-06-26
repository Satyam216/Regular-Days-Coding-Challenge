package Day48; //problem 2200. Find All K-Distant Indices in an Array
import java.util.*;

class Solution {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    res.add(i);
                    break; 
                }
            }
        }
        return res;
    }
}

public class FindKDistantIndices{
    public static void main(String[] args) {

        List<Integer> result = new ArrayList<>();
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        String numbers[] = str.split(",");

        int nums[] = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.parseInt(numbers[i]);
        }

        int key = sc.nextInt();
        int k = sc.nextInt();
        Solution ob = new Solution();
        result = ob.findKDistantIndices(nums, key, k);
        System.out.println(result); 
    }
}