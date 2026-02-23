class Solution {
    public long findSum(long count, long val) {
        return (count * val) - (count * (count + 1)) / 2;
    }

    public int maxValue(int n, int index, int maxSum) {
        long l = 1, h = maxSum;
        long res = 0;
        while (l <= h) {
            long m = l + (h - l) / 2;

            long leftCount = Math.min((long) index, m - 1);
            long leftSum = findSum(leftCount, m) + Math.max(0, index - (m - 1));

            long rightCount = Math.min((long) (n - index - 1), m - 1);
            long rightSum = findSum(rightCount, m) + Math.max(0, (long) (n - index - 1) - (m - 1));

            long totalSum = leftSum + m + rightSum;

            if (totalSum <= maxSum) {
                res = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return (int) res;
    }
}