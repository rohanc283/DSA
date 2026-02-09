class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (k == 0)
            return nums;
        if (2 * k + 1 > n)
            return res;

        long sum = 0;
        int window = 2 * k + 1;
        for (int i = 0; i < window; i++) {
            sum += nums[i];
        }
        int idx = k;
        res[idx] = (int) (sum / window);
        for (int i = window; i < n; i++) {
            sum += nums[i];
            sum -= nums[i - window];
            res[++idx] = (int) (sum / window);
        }
        return res;
    }
}