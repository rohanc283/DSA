class Solution {
    public long beautifulSubstrings(String s, int k) {
        long result = 0L;
        long vowel = 0L, consonant = 0L;
        Map<Long, Map<Long, Long>> map = new HashMap<>();
        map.computeIfAbsent(vowel - consonant, m -> new HashMap<>()).put(0L, 1L);
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1)
                vowel++;
            else
                consonant++;

            long pSum = vowel - consonant;
            if (map.containsKey(pSum)) {
                Map<Long, Long> currMap = map.get(pSum);
                for (Long key : currMap.keySet()) {
                    if ((((vowel % k) - key) * ((vowel % k) - key)) % k == 0) {
                        result += currMap.get(key);
                    }
                }
            }
            map.computeIfAbsent(pSum, m -> new HashMap<>()).put(vowel % k,
                    map.get(pSum).getOrDefault(vowel % k, 0L) + 1L);
        }
        return result;
    }
}