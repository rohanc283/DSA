class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long[] prefix = new long[n];
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += beans[i];
            prefix[i] = s;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long lSum = i == 0 ? 0 : prefix[i - 1];
            long rSum = (prefix[n - 1] - prefix[i]) - (beans[i] * 1L * (n - i - 1));
            ans = Math.min(ans, lSum + rSum);
        }
        return ans;
    }
}