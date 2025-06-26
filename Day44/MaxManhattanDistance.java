package Day44; //problem 3443. Maximum Manhattan Distance After K Changes
import java.util.Scanner;

class Solution {
    public int maxDistance(String s, int k) {
        int east = 0 , west= 0, north = 0, south = 0;
        int actualMD = 0;
        int extraIncrease = 0;
        int maxMD  = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'E') east++;
            else if(s.charAt(i) == 'W') west++;
            else if(s.charAt(i) == 'N') north++;
            else if(s.charAt(i) == 'S') south++;

            actualMD = Math.abs(east - west) + Math.abs
            (north - south);

            int currentStep = i+1;
            int wasteStep = currentStep - actualMD;

            if(wasteStep != 0){
                extraIncrease = Math.min(2*k , wasteStep);
            }
            int finalMD = actualMD + extraIncrease;
            
            maxMD = Math.max(maxMD , finalMD);
            
        }
        return maxMD ;
    }
}

public class MaxManhattanDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k  = sc.nextInt();

        Solution ob = new Solution();
        int result = ob.maxDistance(str, k);
        System.out.println(result);
        sc.close();
    }
    
}
