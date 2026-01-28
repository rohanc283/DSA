class Solution {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long mod = 1_000_000_007L;

        long res = ((long) nums[0] * nums[0] % mod * nums[0]) % mod;
        long prev = nums[0];

        for (int i = 1; i < n; i++) {
            long curr = ((long) nums[i] * nums[i]) % mod;
            curr = (curr * ((nums[i] + prev) % mod)) % mod;

            res = (res + curr) % mod;
            prev = (prev * 2 + nums[i]) % mod;
        }

        return (int) res;
    }
}
