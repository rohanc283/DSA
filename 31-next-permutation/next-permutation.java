class Solution {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void reverse(int[] nums, int s, int e) {
        while (s < e) {
            swap(nums, s++, e--);
        }
    }

    public void nextPermutation(int[] nums) {
        int breakPoint = -1, n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[breakPoint]) {
                swap(nums, i, breakPoint);
                break;
            }
        }

        reverse(nums, breakPoint + 1, n - 1);
    }
}