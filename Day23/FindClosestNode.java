package Day23; //problem 2359
import java.util.*;

class Solution{
public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        fillDistances(edges, node1, dist1);

        fillDistances(edges, node2, dist2);

        int minDistance = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDistance) {
                    minDistance = maxDist;
                    result = i;
                } else if (maxDist == minDistance && i < result) {
                    result = i;
                }
            }
        }

        return result;
    }

    private void fillDistances(int[] edges, int start, int[] dist) {
        int distance = 0;
        int current = start;
        while (current != -1 && dist[current] == -1) {
            dist[current] = distance++;
            current = edges[current];
        }
    }
}
public class FindClosestNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // edgees input
        String str = sc.nextLine();
        String data[] = str.split(" ");
        int edges[] = new int[data.length];
        for(int i=0; i<data.length; i++){
            edges[i] = Integer.parseInt(data[i]);
        }
        int node1 = sc.nextInt();
        int node2 = sc.nextInt();

        Solution ob = new Solution();

        int result = ob.closestMeetingNode(edges, node1, node2);
        System.out.println(result);

    }
    
}
