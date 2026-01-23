class Solution {
    int sol1(int[] nums) {
        int n = nums.length;
        int t = (n * (n + 1)) / 2;
        int s = 0;
        for (int i = 0; i < n; i++)
            s += nums[i];
        return t - s;
    }

    void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    int sol2(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] != n && nums[i] != i) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        for (i = 0; i < n; i++) {
            if (nums[i] != i)
                return i;
        }
        return n;
    }

    public int missingNumber(int[] nums) {
        return sol2(nums);
    }
}