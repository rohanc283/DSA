class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        int mod = 1_000_000_007;

        long[] pos = new long[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                pos[i] = (long) nums[i] + d;
            } else {
                pos[i] = (long) nums[i] - d;
            }
        }

        Arrays.sort(pos);

        long ans = 0;
        long leftSum = 0;

        for (int i = 0; i < n; i++) {
            ans = (ans + (long) i * pos[i] - leftSum) % mod;
            leftSum = (leftSum + pos[i]) % mod;
        }

        if (ans < 0)
            ans += mod;
        return (int) ans;
    }
}
