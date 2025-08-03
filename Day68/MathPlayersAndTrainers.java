package Day68;  //leetcode 2410. Maximum Matching of Players With Trainers
import java.util.*;

class Solution {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int m = players.length;
        int n = trainers.length;
        int count = 0;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;
    }
}

public class MathPlayersAndTrainers {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
    
        String str1 = sc.nextLine();
        String nums1[] = str1.split(",");
        int players[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            players[i] = Integer.parseInt(nums1[i]);
        }

        String str2 = sc.nextLine();
        String nums2[] = str2.split(",");
        int trainers[] = new int[nums2.length];
        for(int i=0; i<nums2.length; i++){
            trainers[i] = Integer.parseInt(nums2[i]);
        }

        Solution ob = new Solution();
        int result = ob.matchPlayersAndTrainers(players, trainers);
        System.out.println(result);
    }   
}
