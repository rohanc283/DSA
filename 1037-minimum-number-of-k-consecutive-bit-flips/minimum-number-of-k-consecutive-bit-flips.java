class Solution {
    public int sol1(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipCount = 0;
        for (int i = 0; i < n; i++) {
            if (i - k >= 0 && nums[i - k] == 5) {
                flipCount--;
            }

            if (flipCount % 2 == nums[i]) {
                if (i + k > n)
                    return -1;
                flipCount++;
                flips++;
                nums[i] = 5;
            }

        }
        return flips;
    }

    public int minKBitFlips(int[] nums, int k) {
        return sol1(nums, k);
    }
}