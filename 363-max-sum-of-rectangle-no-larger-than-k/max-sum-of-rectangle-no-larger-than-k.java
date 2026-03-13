class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        for (int left = 0; left < n; left++) {
            int[] rowSum = new int[m];

            for (int right = left; right < n; right++) {

                for (int r = 0; r < m; r++)
                    rowSum[r] += matrix[r][right];

                ans = Math.max(ans, maxSubArrayNoLargerThanK(rowSum, k));
            }
        }

        return ans;
    }

    private int maxSubArrayNoLargerThanK(int[] arr, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int prefix = 0;
        int ans = Integer.MIN_VALUE;

        for (int num : arr) {
            prefix += num;

            Integer target = set.ceiling(prefix - k);
            if (target != null)
                ans = Math.max(ans, prefix - target);

            set.add(prefix);
        }

        return ans;
    }
}