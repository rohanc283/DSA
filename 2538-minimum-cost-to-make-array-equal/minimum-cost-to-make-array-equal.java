class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] numsWithCost = new int[n][2];
        long total = 0;
        for (int i = 0; i < n; i++) {
            numsWithCost[i][0] = nums[i];
            numsWithCost[i][1] = cost[i];
            total += 1L * cost[i];
        }
        Arrays.sort(numsWithCost, (a, b) -> Long.compare(a[0], b[0]));

        // find median;
        long curr = 0;
        long median = 0;
        for (int i = 0; i < n; i++) {
            curr += numsWithCost[i][1];
            if (curr > total / 2) {
                median = 1L * numsWithCost[i][0];
                break;
            }
        }

        // find cost
        long res = 0;
        for (int i = 0; i < n; i++) {
            long d = Math.abs(numsWithCost[i][0] - median);
            res += (d * 1L * numsWithCost[i][1]);
        }
        return res;
    }
}