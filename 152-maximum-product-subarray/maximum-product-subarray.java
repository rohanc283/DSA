class Solution {
    private int sol1(int[] nums) {
        int currMax = nums[0], currMin = nums[0];
        int res = currMax;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            currMax = Math.max(num, currMax * num);
            currMin = Math.min(num, currMin * num);
            res = Math.max(res, currMax);
        }
        return res;
    }

    private int sol2(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        int l = 0, r = 0;
        int res = Integer.MIN_VALUE;
        while (i < n && j >= 0) {
            l = l == 0 ? nums[i] : nums[i] == 0 ? 0 : l * nums[i];
            r = r == 0 ? nums[j] : nums[j] == 0 ? 0 : r * nums[j];
            res = Math.max(res, Math.max(l, r));
            i++;
            j--;
        }
        return res;
    }

    public int maxProduct(int[] nums) {
        return sol2(nums);
    }
}