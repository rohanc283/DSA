class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
        int MOD = 1_000_000_007;

        while (i < n1 || j < n2) {
            int num1 = i >= n1 ? Integer.MAX_VALUE : nums1[i];
            int num2 = j >= n2 ? Integer.MAX_VALUE : nums2[j];

            if (num1 < num2) {
                sum1 += num1;
                i++;
            } else if (num1 > num2) {
                sum2 += num2;
                j++;
            } else {
                long max = Math.max(sum1, sum2) + num1;
                sum1 = max;
                sum2 = max;
                i++;
                j++;
            }
        }

        return (int) (Math.max(sum1, sum2) % MOD);
    }
}