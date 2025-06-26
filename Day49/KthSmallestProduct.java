package Day49;    //problem 2040. Kth Smallest Product of Two Sorted Arrays
import java.util.Scanner;

class Solution {

    int f(int[] nums2, long x1, long v) {
        int n2 = nums2.length;
        int left = 0, right = n2 - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            long prod = (long) nums2[mid] * x1;
            if ((x1 >= 0 && prod <= v) || (x1 < 0 && prod > v)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (x1 >= 0) {
            return left;
        } else {
            return n2 - left;
        }
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length;
        long left = -10000000000L, right = 10000000000L;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < n1; i++) {
                count += f(nums2, nums1[i], mid);
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

public class KthSmallestProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        String str1 = sc.nextLine();
        String numbers1[] = str1.split(",");

        int nums1[] = new int[numbers1.length];
        for(int i=0; i<numbers1.length; i++){
            nums1[i] = Integer.parseInt(numbers1[i]);
        }

        String str2 = sc.nextLine();
        String numbers2[] = str2.split(",");

        int nums2[] = new int[numbers2.length];
        for(int i=0; i<numbers2.length; i++){
            nums2[i] = Integer.parseInt(numbers2[i]);
        }

        long k = sc.nextLong();

        Solution ob = new Solution();
        long result = ob.kthSmallestProduct(nums1, nums2, k);
        System.out.println(result);
        
    }
    
}
