package Day26; //problem 135
import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int totalCandies = 0;
        for (int c : candies) {
            totalCandies += c;
        }

        return totalCandies;
    }
}

public class Candy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // edge1 input
        String str = sc.nextLine();
        String data[] = str.split(" ");
        int ratings[] = new int[data.length];
        for(int i=0; i<data.length; i++){
            ratings[i] = Integer.parseInt(data[i]);
        }
        Solution ob = new Solution();

        int result = ob.candy(ratings);
        System.out.println(result);
    }
}
