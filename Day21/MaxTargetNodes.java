package Day21; //problem3372
import java.util.*;

class Solution {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1, m = edges2.length + 1;
        int[] count1 = build(edges1, k);
        int[] count2 = build(edges2, k - 1);
        int maxCount2 = 0;
        for (int c : count2) {
            if (c > maxCount2) {
                maxCount2 = c;
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[i] + maxCount2;
        }
        return res;
    }

    private int[] build(int[][] edges, int k) {
        int n = edges.length + 1;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(i, -1, children, k);
        }
        return res;
    }

    private int dfs(int node, int parent, List<List<Integer>> children, int k) {
        if (k < 0) {
            return 0;
        }
        int res = 1;
        for (int child : children.get(node)) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, node, children, k - 1);
        }
        return res;
    }
}

public class MaxTargetNodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //edge1
        String str = sc.nextLine();
        String rows[] = str.split(",");
        int edges1[][] = new int[rows.length][];

        for(int i=0; i<rows.length; i++){
            String columns[] = rows[i].split("\\s+");
            edges1[i] = new int[columns.length];
            for(int j=0; j<columns.length; j++){
                edges1[i][j] = Integer.parseInt(columns[j]);
            }
        }

        //edge2
        String str2 = sc.nextLine();
        String rowsstr2[] = str2.split(",");
        int edges2[][] = new int[rowsstr2.length][];

        for(int i=0; i<rowsstr2.length; i++){
            String columns[] = rowsstr2[i].split("\\s+");
            edges2[i] = new int[columns.length];
            for(int j=0; j<columns.length; j++){
                edges2[i][j] = Integer.parseInt(columns[j]);
            }
        }

        int k = sc.nextInt();
        Solution ob = new Solution();
        int[] result = ob.maxTargetNodes(edges1, edges2, k);
        System.out.println(Arrays.toString(result));
        sc.close();
    }
    
}
