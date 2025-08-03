package Day87;  //118. Pascal's Triangle
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



class Solution{
    public List<List<Integer>> result(int n){
        List<List<Integer>> result = new ArrayList<>();
            
        for(int i=0; i<n; i++){
            List<Integer> row = new ArrayList<Integer>();

            for(int j=0; j<=i; j++){
                row.add(1);
            }
            for(int j=1; j<i; j++){
                int value = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                row.set(j, value);
            }
            result.add(row);
        }
        
        return result;
    }
    
}

public class PascalsTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution ob = new Solution();
        List<List<Integer>> result = ob.result(n);
        System.out.println(result);
    }   
}
