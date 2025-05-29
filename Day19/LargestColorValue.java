package Day19;  //problem 1857
import java.util.*;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
                int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0) queue.offer(i);
        int[][] colorCount = new int[n][26];
        int visited = 0, maxColor = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            int colorIndex = colors.charAt(node) - 'a';
            colorCount[node][colorIndex]++;
            maxColor = Math.max(maxColor, colorCount[node][colorIndex]);

            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    colorCount[neighbor][c] = Math.max(colorCount[neighbor][c], colorCount[node][c]);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        return visited == n ? maxColor : -1;
    }
}

public class LargestColorValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String colors = sc.nextLine();

        //2D array
        String str = sc.nextLine();
        String rows[] = str.split(",");
        int edges[][] = new int[rows.length][];

        for(int i=0; i<rows.length; i++){
            String columns[] = rows[i].split("\\s+");
            edges[i] = new int[columns.length];
            for(int j=0; j<columns.length; j++){
                edges[i][j] = Integer.parseInt(columns[j]);
            }
        }

        Solution ob = new Solution();
        int result = ob.largestPathValue(colors, edges);
        System.out.println(result);
    }
}
