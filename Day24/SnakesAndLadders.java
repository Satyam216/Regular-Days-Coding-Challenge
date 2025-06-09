package Day24; //problem 909
import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
         int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});  // {square, moves}
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int square = current[0];
            int moves = current[1];

            for (int i = 1; i <= 6; i++) {
                int next = square + i;
                if (next > n * n) continue; 

                int[] pos = getCoordinates(next, n);
                int row = pos[0], col = pos[1];

                if (board[row][col] != -1) {
                    next = board[row][col];
                }

                if (next == n * n) {
                    return moves + 1;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, moves + 1});
                }
            }
        }

        return -1;
    }
    private int[] getCoordinates(int s, int n) {
        int quot = (s - 1) / n;
        int rem = (s - 1) % n;
        int row = n - 1 - quot;
        int col = (quot % 2 == 0) ? rem : n - 1 - rem;
        return new int[]{row, col};
    }
}

public class SnakesAndLadders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // board
        String str = sc.nextLine();
        String rows[] = str.split(",");
        int board[][] = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String columns[] = rows[i].trim().split("\\s+");
            board[i] = new int[columns.length];
            for (int j = 0; j < columns.length; j++) {
                board[i][j] = Integer.parseInt(columns[j]);
            }
        }
        Solution ob = new Solution();

        int result = ob.snakesAndLadders(board);
        System.out.println(result);
    }
    
}
