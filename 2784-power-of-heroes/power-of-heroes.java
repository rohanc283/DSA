class Solution {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        long prefix = 0;
        long sum = 0;
        int MOD = 1_000_000_007;
        for (int i = 0; i < nums.length; i++) {
            prefix *= 2;
            long num = nums[i];
            long prev = i > 0 ? nums[i - 1] : 0;
            long sq = (num * num);
            long curr = ((sq % MOD) * ((num + prev + prefix) % MOD)) % MOD;
            sum = (sum + curr) % MOD;
            prefix = (prefix + prev) % MOD;
        }
        return (int) sum;
    }
}