package Day11;

import java.util.Scanner;

class Solution {
    public String triangleType(int[] nums) {
        if (nums.length != 3) {
            return "none";
        }

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}   

public class TypesOfTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String data[] = str.split(",");
        int arr[] = new int[data.length];

        for(int i=0; i<data.length; i++){
            arr[i] = Integer.parseInt(data[i]);
        }

        Solution ob = new Solution();
        String result = ob.triangleType(arr);
        System.out.println(result);
        sc.close();
    }
}
