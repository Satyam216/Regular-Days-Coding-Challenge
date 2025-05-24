package Day15;
import java.util.Scanner;

class Solution{
    public static int majorElement(int nums[]){
        int count  = 0;
        int element = 0;
        for(int num : nums){
             if(count == 0 ){
                element = num;
             }
            count += (element == num) ? 1 : -1;
        }
        //for cross check that elemnt is coming n/2 times
        count = 0;
        for(int num : nums){
            if(num == element){
                count++ ;
            }
        }
        if (count > nums.length/2){
            return element;
        }
        return -1;
    }
}
public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String data[] = str.split(",");
        int nums[] = new int[data.length];
        for(int i=0; i<data.length; i++){
            nums[i] = Integer.parseInt(data[i]);
        }

        Solution ob = new Solution();
        int result = ob.majorElement(nums);
        System.out.println(result);
    }
}
