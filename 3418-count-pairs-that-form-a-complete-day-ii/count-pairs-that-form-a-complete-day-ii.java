class Solution {
    public long countCompleteDayPairs(int[] hours) {
        Map<Long, Long> map = new HashMap<>();
        long pairs = 0;

        for (int t : hours) {
            long rem = t % 24;
            if (rem == 0L) {
                pairs += map.getOrDefault(0L, 0L);
            } else {
                pairs += map.getOrDefault(24 - rem, 0L);
            }
            map.put(rem, map.getOrDefault(rem, 0L) + 1L);
        }
        return pairs;
    }
}