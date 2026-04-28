class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int segments = 0;
        int maxPos = 0;

        for (int i = 0; i < n; i++) {
            maxPos = Math.max(maxPos, map.get(nums[i]));

            if (maxPos == i) {
                segments++;
            }
        }

        long mod = 1_000_000_007;
        long ans = 1;

        for (int i = 0; i < segments - 1; i++) {
            ans = (ans * 2) % mod;
        }

        return (int) ans;
    }
}