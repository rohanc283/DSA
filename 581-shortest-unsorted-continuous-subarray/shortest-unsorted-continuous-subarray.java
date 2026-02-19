class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        int n = nums.length;
        if (n == 1 || n == 0)
            return 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    mini = Math.min(mini, nums[i]);
                    maxi = Math.max(maxi, nums[i]);
                }
            } else if (i == n - 1) {
                if (nums[i - 1] > nums[i]) {
                    mini = Math.min(mini, nums[i]);
                    maxi = Math.max(maxi, nums[i]);
                }
            } else {
                if (nums[i - 1] > nums[i] || nums[i] > nums[i + 1]) {
                    mini = Math.min(mini, nums[i]);
                    maxi = Math.max(maxi, nums[i]);
                }
            }
        }
        if (mini == Integer.MAX_VALUE && maxi == Integer.MIN_VALUE)
            return 0;
        int i = 0, j = n - 1;
        while (i < n && nums[i] <= mini)
            i++;
        while (j >= 0 && nums[j] >= maxi)
            j--;
        return j - i + 1;
    }
}