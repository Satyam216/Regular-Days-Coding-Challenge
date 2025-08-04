package Day90;
import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0; 
        int j=0;
        int count =0;
        int n = fruits.length;

        while(j<n){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);

            if(map.size() <=2){
                count = Math.max(count, j-i+1);
            }else{
                map.put(fruits[i], map.get(fruits[i]) -1);
                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            j++;
        }
        return count;
    }
}

public class FruitIntoBasket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String arr[] = str.split(" ");
        int fruits[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            fruits[i] = Integer.parseInt(arr[i]);
        }

        Solution ob = new Solution();
        int result = ob.totalFruit(fruits);
        System.out.println(result);
        
    }
    
}
