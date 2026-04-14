class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        while (i > 0 && nums[i - 1] >= nums[i])
            i--;
        if (i == 0) {
            reverse(nums, i, n - 1);
            return;
        }
        int changingPos = i - 1;
        i = n - 1;
        while (i > changingPos && nums[i] <= nums[changingPos])
            i--;
        swap(nums, changingPos, i);
        reverse(nums, changingPos + 1, n - 1);
    }
}