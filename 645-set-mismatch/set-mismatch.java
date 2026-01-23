class Solution {
    void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] != nums[nums[i] - 1] && nums[i] - 1 != i) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        int[] ans = new int[2];
        for (i = 0; i < n; i++) {
            if (nums[i] - 1 != i) {
                ans[0] = nums[i];
                ans[1] = i + 1;
                break;
            }
        }
        return ans;
    }
}