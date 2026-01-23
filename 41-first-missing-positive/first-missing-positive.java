class Solution {
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] > 0 && nums[i] - 1 < n && nums[i] != nums[nums[i] - 1] && nums[i] - 1 != i) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < n; i++) {
            if (nums[i] - 1 != i)
                return i + 1;
        }
        return i + 1;
    }
}