    package Day15;  //problem 3068
    import java.util.*;

    class Solution {
        public static long maximumValueSum(int[] nums, int k, int[][] edges) {
            long sum = 0;
            List<Long> res = new ArrayList<>();
            for (int x : nums) {
                sum += x;
                long y = x ^ k;
                res.add(y - x);
            }
            Collections.sort(res, Collections.reverseOrder());
            for (int i = 0; i + 1 < res.size(); i += 2) {
                if (res.get(i) + res.get(i + 1) <= 0) {
                    break;
                }
                sum += res.get(i) + res.get(i + 1);
            }
            return sum;
        }
    }

    public class MaximumSumOfNodes {
        public static void main(String[] args) {
            
        Scanner sc = new Scanner(System.in);
            int k = sc.nextInt();

        //1D array
        String str = sc.nextLine();
        String data[] = str.split(",");
        int nums[] = new int[data.length];
        for(int i=0; i<data.length; i++){
            nums[i] = Integer.parseInt(data[i]);
        }

        //2D array (querries)
        String input = sc.nextLine();
        String[] rows = input.split(",");

        int[][] edges = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] cols = rows[i].split("\\s+");
            edges[i] = new int[cols.length];
            for (int j = 0; j < cols.length; j++) {
                edges[i][j] = Integer.parseInt(cols[j]);
            }
        }
        Solution ob = new Solution();
        long result = ob.maximumValueSum(nums,k,edges);
        System.out.println(result);
        }
    }
