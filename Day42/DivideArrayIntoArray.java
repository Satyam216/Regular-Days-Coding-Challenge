package Day42; //problem 2966. Divide Array Into Arrays With Max Difference
import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] used = new boolean[n];
        List<List<Integer>> tempResult = new ArrayList<>();

        for (int i = 0; i < n; ) {
            if (used[i]) {
                i++;
                continue;
            }

            List<Integer> group = new ArrayList<>();
            group.add(nums[i]);
            used[i] = true;
            for (int j = i + 1; j < n && group.size() < 3; j++) {
                if (!used[j] && nums[j] - group.get(0) <= k) {
                    group.add(nums[j]);
                    used[j] = true;
                }
            }

            if (group.size() != 3) return new int[0][];
            tempResult.add(group);
        }
         int[][] result = new int[tempResult.size()][3];
         for (int i = 0; i < tempResult.size(); i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = tempResult.get(i).get(j);
            }
        }
        return result;  
    }
}
public class DivideArrayIntoArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        String numbers[] = str.split(",");

        int nums[] = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.parseInt(numbers[i]);
        }
        int k = sc.nextInt();
        Solution ob = new Solution();
        int result[][] = ob.divideArray(nums , k);

        if (result.length == 0) {
            System.out.println("[]");
        }else {
            for (int i = 0; i < result.length; i++) {
                System.out.print(Arrays.toString(result[i]));
                if (i != result.length - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}
