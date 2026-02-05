class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }

        long totalPairs = (long) n * (n - 1) / 2;
        long goodPairs = 0;

        for (long freq : map.values()) {
            goodPairs += freq * (freq - 1) / 2;
        }

        return totalPairs - goodPairs;
    }
}