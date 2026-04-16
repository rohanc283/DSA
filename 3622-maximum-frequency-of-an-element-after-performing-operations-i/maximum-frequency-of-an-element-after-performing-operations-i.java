class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        int maxi = 0;

        // find maximum
        for (int num : nums)
            maxi = Math.max(maxi, num);

        // storing freq
        int[] freq = new int[maxi + 1];
        for (int num : nums)
            freq[num]++;

        // cumulative sum
        for (int i = 1; i <= maxi; i++) {
            freq[i] += freq[i - 1];
        }

        int maxFreq = 0;
        for (int target = 0; target <= maxi; target++) {
            if (freq[target] == 0)
                continue;
            int totalFreq = freq[Math.min(target + k, maxi)] - (target - k > 0 ? freq[target - k - 1] : 0);
            System.out.println(totalFreq);
            int currNumFreq = freq[target] - (target > 0 ? freq[target - 1] : 0);
            int reqOp = totalFreq - currNumFreq;
            maxFreq = Math.max(maxFreq, currNumFreq + Math.min(reqOp, numOperations));
        }
        return maxFreq;
    }
}