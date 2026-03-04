class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxi = 0;
        for (int num : nums)
            maxi = Math.max(maxi, num);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += maxi;
            maxi++;
        }
        return res;
    }
}