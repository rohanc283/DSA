class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        int mini = nums[0], maxi = nums[0];
        for (int num : nums) {
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
        }

        int bucketSize = ((maxi - mini) + (n - 1) - 1) / (n - 1);
        int bucketLength = n - 1;
        int[] bucketMin = new int[bucketLength];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        int[] bucketMax = new int[bucketLength];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == maxi || num == mini)
                continue;
            int bucketIdx = (num - mini) / bucketSize;
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], num);
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], num);
        }
        int res = 0;
        int prevMax = mini;
        for (int i = 0; i < bucketLength; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE)
                continue;
            res = Math.max(res, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
        res = Math.max(res, maxi - prevMax);
        return res;
    }
}