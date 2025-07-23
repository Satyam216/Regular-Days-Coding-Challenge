package Day69; //leetcode 1290. Convert Binary Number in a Linked List to Integer
import java.util.*;

class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public int getDecimalValue(ListNode head) {
        int decimal = 0;
        while(head != null){
            decimal = (decimal << 1) | head.val;
            head = head.next;
        }
        return decimal;
    }
}

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the binary number as space-separated digits (e.g., 1 0 1):");
        String[] input = sc.nextLine().split(" ");

        // Create linked list from input
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String s : input) {
            int bit = Integer.parseInt(s);
            if (bit != 0 && bit != 1) {
                System.out.println("Invalid input! Only binary digits (0 or 1) are allowed.");
                return;
            }
            current.next = new ListNode(bit);
            current = current.next;
        }

        // Call the conversion function
        Solution sol = new Solution();
        int result = sol.getDecimalValue(dummy.next);

        System.out.println("Decimal value: " + result);
    }
}
