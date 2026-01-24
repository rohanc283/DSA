class Solution {
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int[] ans = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0)
                ans[k++] = nums[i];
        }
        while (k < n) {
            ans[k++] = 0;
        }
        return ans;
    }
}