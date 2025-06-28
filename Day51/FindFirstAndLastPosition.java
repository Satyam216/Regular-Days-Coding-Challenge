package Day51;

import java.util.Arrays;
import java.util.Scanner;

class Solution{
    public int[] findRange(int nums[], int target){
        int result[] = {-1, -1};
        int left = 0;
        int right = nums.length -1 ;
        int mid = 0;

        //for left most position
            while(left <= right){
                mid = left + (right - left) /2 ;
                if(nums[mid] == target){
                    result[0] = mid;
                    right = mid -1 ;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }

        //for right most position
            left = 0;
            right = nums.length -1 ;
            while(left <= right){
                mid = left + (right - left) /2 ;
                if(nums[mid] == target){
                    result[1] = mid;
                    left = mid + 1 ;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }

        return result;

    }
}

public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String arr[] = str.split(",");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        int target = sc.nextInt();

        Solution ob = new Solution();
        int result[] = ob.findRange(nums, target);
        System.out.println(Arrays.toString(result));
    }
    
}
