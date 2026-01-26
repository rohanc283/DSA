class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += beans[i];
        }
        long ans = Long.MAX_VALUE;
        long leftSum = 0;
        for (int i = 0; i < n; i++) {
            long rightSum = (totalSum - (leftSum + beans[i])) - (beans[i] * 1L * (n - i - 1));
            ans = Math.min(ans, leftSum + rightSum);
            leftSum += beans[i];
        }
        return ans;
    }
}