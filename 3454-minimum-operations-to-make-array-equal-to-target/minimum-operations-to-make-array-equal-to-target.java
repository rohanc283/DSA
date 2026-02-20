class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        long[] diff = new long[n];
        for (int i = 0; i < n; i++) {
            diff[i] = target[i] - nums[i];
        }
        long res = 0;
        long prev = 0;
        for (long curr : diff) {
            if (curr >= 0 && prev < 0) {
                res += Math.abs(curr);
            } else if (curr < 0 && prev >= 0) {
                res += Math.abs(curr);
            } else {
                if (Math.abs(curr) > Math.abs(prev)) {
                    res += (Math.abs(curr) - Math.abs(prev));
                }
            }
            prev = curr;
        }
        return res;
    }
}