class Solution {
    public int sol2(int[] nums) {
        int low = 1, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int count = 0;
            for (int num : nums) {
                if (num <= mid)
                    count++;
            }

            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

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