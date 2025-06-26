package Day43;  //problem 2294. Partition Array Such That Maximum Difference Is K
import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int start = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i] - start > k){
                count++;
                start = nums[i];
            }
        }
        return count;  
    }
}
public class PartitionArray {
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
        int result = ob.partitionArray(nums , k);
        System.out.println(result); 
    }    
}
