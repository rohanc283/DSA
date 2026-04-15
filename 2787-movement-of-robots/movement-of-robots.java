class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                pos[i] = nums[i] + (long) d;
            } else {
                pos[i] = nums[i] - (long) d;
            }
        }

        Arrays.sort(pos);
        long res = 0;
        long sum = pos[0];

        for (int i = 1; i < n; i++) {
            long curr = ((long) pos[i] * i % MOD - sum % MOD + MOD) % MOD;
            res = (res + curr) % MOD;
            sum = (sum + pos[i]) % MOD;
        }

        return (int) res;
    }
}