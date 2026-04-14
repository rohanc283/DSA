class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] sortArrayByParityII(int[] nums) {
        int even = 0, odd = 1;
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (i % 2 == 0) {
                if (nums[i] % 2 == 0) {
                    i++;
                    continue;
                }
                swap(nums, i, odd);
                odd += 2;
            } else {
                if (nums[i] % 2 != 0) {
                    i++;
                    continue;
                }
                swap(nums, i, even);
                even += 2;
            }
        }
        return nums;
    }
}