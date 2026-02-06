class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Long, Long> map = new HashMap<>();
        long result = 0L;
        long xor = 0L;
        map.put(xor, 1L);
        for (int num : nums) {
            xor ^= (long) num;
            long val = map.getOrDefault(xor, 0L);
            result += val;
            map.put(xor, val + 1L);
        }
        return result;
    }
}