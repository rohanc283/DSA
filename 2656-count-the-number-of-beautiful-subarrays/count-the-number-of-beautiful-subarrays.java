class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        long xor = 0, res = 0;
        for (int num : nums) {
            xor ^= num;
            long val = map.getOrDefault(xor, 0L);
            res += val;
            map.put(xor, val + 1);
        }
        return res;
    }
}