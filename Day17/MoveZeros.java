package Day17;
import java.util.Arrays;
import java.util.Scanner;
class Solution {
    public void moveZeroes(int[] nums) {
        int position = 0;
        for(int num : nums){
            if(num != 0){
                nums[position] = num;
                position++;            }
        }

        while(position < nums.length){
            nums[position] = 0;
            position++ ;
        }
    }
}
public class MoveZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String data[] = str.split(",");
        int nums[] = new int[data.length];
        for(int i=0; i<data.length; i++){
            nums[i] = Integer.parseInt(data[i]);
        }
        Solution ob = new Solution();
        ob.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}