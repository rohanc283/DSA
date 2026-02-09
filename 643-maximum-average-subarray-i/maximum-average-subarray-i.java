class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = Double.NEGATIVE_INFINITY, sum = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (j >= k - 1) {
                double avg = sum / k;
                res = Math.max(res, avg);
                sum -= nums[i++];
            }
        }
        return res;
    }
}