class Solution {
    int sol1(int[] nums) {
        int n = nums.length;
        int t = (n * (n + 1)) / 2;
        int s = 0;
        for (int i = 0; i < n; i++)
            s += nums[i];
        return t - s;
    }
    

    public int missingNumber(int[] nums) {
        return sol1(nums);
    }
}