class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length, s = -1, e = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) {
                s = e = i;
            } else if (nums[i] >= left) {
                e = i;
            }
            res += (e - s);
        }
        return res;
    }
}