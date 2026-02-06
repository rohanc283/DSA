class Solution {
    public long wonderfulSubstrings(String word) {
        long result = 0;
        long xor = 0;
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        for (char c : word.toCharArray()) {
            int shift = c - 'a';
            xor ^= (1 << shift);
            result += map.getOrDefault(xor, 0L);
            for (char c1 = 'a'; c1 <= 'j'; c1++) {
                shift = c1 - 'a';
                result += map.getOrDefault(xor ^ (1 << shift), 0L);
            }
            map.put(xor, map.getOrDefault(xor, 0L) + 1L);
        }
        return result;
    }
}