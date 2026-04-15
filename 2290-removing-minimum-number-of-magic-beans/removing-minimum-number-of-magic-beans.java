class Solution {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long total = 0;
        for (int bean : beans)
            total += 1L * bean;
        long leftBeans = 0;
        long minRemoval = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int rem = n - i - 1;
            long left = total - (leftBeans + beans[i]);
            long right = Math.abs((1L * beans[i] * rem) - left);
            minRemoval = Math.min(minRemoval, leftBeans + right);
            leftBeans += beans[i];
        }
        return minRemoval;
    }
}