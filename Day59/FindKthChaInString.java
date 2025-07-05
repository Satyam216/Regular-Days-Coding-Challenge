package Day59;

import java.util.Scanner;
import java.util.ArrayList;

class Solution {

    public char kthCharacter(long k, int[] operations) {
        char c = 'a';
        int n = operations.length;
        ArrayList<Integer> opHistory = new ArrayList<>();

        while (k > 1) {
            long len = 1;
            int index = 0;

            while (len * 2 < k) {
                len *= 2;
                index++;
            }

            index = index % n;
            opHistory.add(index);
            k = k - len;
        }

        for (int i = opHistory.size() - 1; i >= 0; i--) {
            int op = operations[opHistory.get(i)];
            c += op;
            if (c > 'z') {
                c = (char) ('a' + (c - 'z' - 1));
            }
        }

        return c;
    }
}

public class FindKthChaInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str = sc.nextLine();
        String arr[] = str.split(",");
        int operations[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            operations[i] = Integer.parseInt(arr[i]);
        }

        Solution ob = new Solution();
        char result = ob.kthCharacter(k, operations);
        System.out.println(result);
    }
    
}
