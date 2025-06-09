package Day22; //problem 2373
import java.util.*;

public class MaxTargetNodes2 {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        int[] color1 = new int[n];
        int[] color2 = new int[m];
        int[] count1 = build(edges1, color1);
        int[] count2 = build(edges2, color2);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[color1[i]] + Math.max(count2[0], count2[1]);
        }
        return res;
    }

    private int[] build(int[][] edges, int[] color) {
        int n = edges.length + 1;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int res = dfs(0, -1, 0, children, color);
        return new int[] { res, n - res };
    }

    private int dfs(
        int node,
        int parent,
        int depth,
        List<List<Integer>> children,
        int[] color
    ) {
        int res = 1 - (depth % 2);
        color[node] = depth % 2;
        for (int child : children.get(node)) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, node, depth + 1, children, color);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // edge1 input
        String str = sc.nextLine();
        String rows[] = str.split(",");
        int edges1[][] = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String columns[] = rows[i].trim().split("\\s+");
            edges1[i] = new int[columns.length];
            for (int j = 0; j < columns.length; j++) {
                edges1[i][j] = Integer.parseInt(columns[j]);
            }
        }

        // edge2 input
        String str2 = sc.nextLine();
        String rowsstr2[] = str2.split(",");
        int edges2[][] = new int[rowsstr2.length][];

        for (int i = 0; i < rowsstr2.length; i++) {
            String columns[] = rowsstr2[i].trim().split("\\s+");
            edges2[i] = new int[columns.length];
            for (int j = 0; j < columns.length; j++) {
                edges2[i][j] = Integer.parseInt(columns[j]);
            }
        }

        MaxTargetNodes2 obj = new MaxTargetNodes2();
        int[] result = obj.maxTargetNodes(edges1, edges2);
        System.out.println(Arrays.toString(result));
    }
}
