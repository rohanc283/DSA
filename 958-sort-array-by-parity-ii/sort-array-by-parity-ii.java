class Solution {
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int[] sortArrayByParityII(int[] nums) {
        int evenIndex = 0, oddIndex = 1, n = nums.length;
        while (evenIndex < n && oddIndex < n) {
            if (nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            } else if (nums[oddIndex] % 2 != 0) {
                oddIndex += 2;
            } else {
                swap(nums, evenIndex, oddIndex);
                evenIndex += 2;
                oddIndex += 2;
            }
        }
        return nums;
    }
}