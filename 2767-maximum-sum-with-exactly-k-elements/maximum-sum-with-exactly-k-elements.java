class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            res += nums[n - 1];
            nums[n - 1]++;
        }
        return res;
    }
}