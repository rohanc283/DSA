class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return 0;

        int maxi = 0, mini = Integer.MAX_VALUE;
        for (int num : nums) {
            maxi = Math.max(maxi, num);
            mini = Math.min(mini, num);
        }

        int bucketSize = (int) Math.ceil((double) (maxi - mini) / (n - 1));
        if (bucketSize == 0)
            bucketSize = 1;
        int[] minBucket = new int[n - 1];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        int[] maxBucket = new int[n - 1];
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == mini || num == maxi)
                continue;
            int bucketIdx = (num - mini) / bucketSize;
            minBucket[bucketIdx] = Math.min(minBucket[bucketIdx], num);
            maxBucket[bucketIdx] = Math.max(maxBucket[bucketIdx], num);
        }
        int prev = mini;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (minBucket[i] == Integer.MAX_VALUE)
                continue;
            res = Math.max(res, minBucket[i] - prev);
            prev = maxBucket[i];
        }
        res = Math.max(maxi - prev, res);
        return res;
    }
}