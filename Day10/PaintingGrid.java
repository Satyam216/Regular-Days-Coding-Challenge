package Day10;  //problem 1931

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    static final int MOD = 1_000_000_007;
    public int colorTheGrid(int m, int n) {
        List<List<Integer>> validRows = new ArrayList<>();
        generateValidRows(m, new ArrayList<>(), validRows);

        Map<List<Integer>, List<List<Integer>>> compatible = new HashMap<>();

        for (List<Integer> row1 : validRows) {
            for (List<Integer> row2 : validRows) {
                if (isCompatible(row1, row2)) {
                    compatible.computeIfAbsent(row1, k -> new ArrayList<>()).add(row2);
                }
            }
        }

        Map<List<Integer>, Integer> dp = new HashMap<>();
        for (List<Integer> row : validRows) {
            dp.put(row, 1);
        }

        for (int col = 1; col < n; col++) {
            Map<List<Integer>, Integer> newDp = new HashMap<>();
            for (List<Integer> row : validRows) {
                int count = 0;
                for (List<Integer> prev : compatible.get(row)) {
                    count = (count + dp.get(prev)) % MOD;
                }
                newDp.put(row, count);
            }
            dp = newDp;
        }

        int result = 0;
        for (int count : dp.values()) {
            result = (result + count) % MOD;
        }

        return result;
    }

    private void generateValidRows(int m, List<Integer> current, List<List<Integer>> validRows) {
        if (current.size() == m) {
            validRows.add(new ArrayList<>(current));
            return;
        }

        for (int color = 0; color < 3; color++) {
            if (current.isEmpty() || current.get(current.size() - 1) != color) {
                current.add(color);
                generateValidRows(m, current, validRows);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isCompatible(List<Integer> row1, List<Integer> row2) {
        for (int i = 0; i < row1.size(); i++) {
            if (row1.get(i).equals(row2.get(i))) {
                return false;
            }
        }
        return true;
    }
}

public class PaintingGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Solution ob = new Solution();
        int result = ob.colorTheGrid(m, n);
        System.out.println(result);
    }
    
}
