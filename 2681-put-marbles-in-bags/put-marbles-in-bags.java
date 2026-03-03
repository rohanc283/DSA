class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length, m = n - 1;
        long[] pairSum = new long[m];
        for (int i = 0; i < m; i++) {
            pairSum[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairSum);
        long minSum = 0;
        long maxSum = 0;
        for (int i = 0; i < k - 1; i++) {
            minSum += pairSum[i];
            maxSum += pairSum[m - 1 - i];
        }
        return maxSum - minSum;
    }
}