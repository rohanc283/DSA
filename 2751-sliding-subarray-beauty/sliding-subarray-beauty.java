class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] freq = new int[51];
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] < 0) {
                freq[Math.abs(nums[j])]++;
            }
            if (j >= k - 1) {
                int y = x;
                for (int neg = 50; neg >= 0; neg--) {
                    if (freq[neg] == 0)
                        continue;

                    y -= freq[neg];
                    if (y <= 0) {
                        res[i] = -neg;
                        break;
                    }
                }
                if (nums[i] < 0) {
                    freq[Math.abs(nums[i])]--;
                }
                i++;
            }
        }
        return res;
    }
}