package Day29;  //problem 1061
 
import java.util.Scanner;

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            union(parent, a, b);
        }

        
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int root = find(parent, c - 'a');
            sb.append((char)(root + 'a'));
        }
        return sb.toString();
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
    }
}

public class LexicographicallySmallestString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String baseStr = sc.nextLine();

        Solution ob = new Solution();
        String result = ob.smallestEquivalentString(s1, s2, baseStr);
        System.out.println(result);
    }
    
}
