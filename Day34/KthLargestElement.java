package Day34;  //problem 215
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution{
    public int largestElement(int nums[] , int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            minHeap.add(nums[i]);
            
            if(minHeap.size() > k){
                minHeap.poll();
            }
        } 
        return minHeap.peek();
    }  
}

public class KthLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String arr[] = str.split(" ");
        int nums[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        int k = sc.nextInt();

        Solution ob = new Solution();
        int result = ob.largestElement(nums, k);
        System.out.println(result);

    }
    
}
