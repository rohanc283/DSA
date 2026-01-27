class Solution {
    public int prefixSumTech(int[] nums, int k, int numOperations) {
        int maxEl = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            maxEl = Math.max(maxEl, nums[i]);
        }
        int[] freq = new int[maxEl + 1];
        for (int i = 0; i < n; i++)
            freq[nums[i]]++;

        for (int i = 1; i <= maxEl; i++)
            freq[i] += freq[i - 1];

        int res = 0;
        for (int target = 0; target <= maxEl; target++) {
            if (freq[target] == 0)
                continue;
            int leftNum = Math.max(0, target - k);
            int rightNum = Math.min(maxEl, target + k);
            int totalCount = freq[rightNum] - (leftNum > 0 ? freq[leftNum - 1] : 0);
            int targetCount = freq[target] - (target > 0 ? freq[target - 1] : 0);
            int needConversion = totalCount - targetCount;
            int maxPosFreq = targetCount + Math.min(numOperations, needConversion);
            res = Math.max(res, maxPosFreq);
        }
        return res;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        return prefixSumTech(nums, k, numOperations);
    }
}