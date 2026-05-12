class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        long xor = 0, res = 0;
        for (char c : word.toCharArray()) {
            xor ^= (1L << (c - 'a'));
            long val = map.getOrDefault(xor, 0L);
            res += val;
            for (char ch = 'a'; ch <= 'j'; ch++) {
                res += map.getOrDefault(xor ^ (1 << (ch - 'a')), 0L);
            }
            map.put(xor, val + 1);
        }
        return res;
    }
}