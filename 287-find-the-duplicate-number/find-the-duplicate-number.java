class Solution {
    void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public int findDuplicate(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] != i) {
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        return -1;
    }
}