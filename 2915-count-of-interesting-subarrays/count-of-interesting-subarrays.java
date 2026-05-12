class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = ((nums.get(i) % modulo) == k) ? 1 : 0;
        }

        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L);
        long res = 0;
        int prefix = 0;
        for (int c : count) {
            prefix = (prefix + c) % modulo;
            int rem = ((prefix - k) + modulo) % modulo;
            res += map.getOrDefault(rem, 0L);
            map.put(prefix, map.getOrDefault(prefix, 0L) + 1L);
        }
        return res;
    }
}