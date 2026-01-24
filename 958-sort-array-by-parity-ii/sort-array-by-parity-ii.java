class Solution {
    void swap(int[] nums, int i, int j) {
        if (i >= nums.length || j >= nums.length)
            return;
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int[] sortArrayByParityII(int[] nums) {
        int evenIndex = 0, oddIndex = 1, n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] % 2 == 0) {
                swap(nums, i, evenIndex);
                evenIndex += 2;
            } else {
                swap(nums, i, oddIndex);
                oddIndex += 2;
            }

            if (i % 2 == 0 && nums[i] % 2 == 0)
                i++;
            if (i % 2 != 0 && nums[i] % 2 != 0)
                i++;
        }
        return nums;

    }
}