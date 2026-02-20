class Solution {
    public int maximumScore(int[] nums, int k) {
        int i = k, j = k, n = nums.length;
        int res = nums[k], currMin = nums[k];
        while (i > 0 || j < n - 1) {
            int leftVal = i > 0 ? nums[i - 1] : 0;
            int rightVal = j < n - 1 ? nums[j + 1] : 0;
            if (leftVal < rightVal) {
                j++;
                currMin = Math.min(currMin, nums[j]);
            } else {
                i--;
                currMin = Math.min(currMin, nums[i]);
            }
            res = Math.max(res, currMin * (j - i + 1));
        }
        return res;
    }
}