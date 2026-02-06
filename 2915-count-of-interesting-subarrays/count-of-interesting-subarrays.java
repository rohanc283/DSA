class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        long count = 0, sum = 0, m = (long) modulo;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) % m == k)
                sum++;
            long r1 = sum % m;
            long r2 = (r1 - k + m) % m;
            if (map.containsKey(r2)) {
                count += map.get(r2);
            }
            map.put(r1, map.getOrDefault(r1, 0L) + 1L);
        }
        return count;
    }
}