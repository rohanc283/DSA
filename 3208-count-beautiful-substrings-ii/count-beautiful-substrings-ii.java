class Solution {
    public long beautifulSubstrings(String s, int k) {
        Map<Long, Map<Long, Long>> map = new HashMap<>();
        map.computeIfAbsent(0L, m -> new HashMap<>()).put(0L, 1L);
        long vowelCount = 0, consonentCount = 0;
        long res = 0;
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                vowelCount++;
            } else {
                consonentCount++;
            }
            long key = vowelCount - consonentCount;
            if (map.containsKey(key)) {
                Map<Long, Long> keyMap = map.get(key);
                for (Long currKey : keyMap.keySet()) {
                    long currVowel = (vowelCount % k) - currKey;
                    if ((currVowel * currVowel) % k == 0)
                        res += keyMap.get(currKey);
                }
                map.get(key).put((vowelCount % k), map.get(key).getOrDefault((vowelCount % k), 0L) + 1L);
            } else {
                map.computeIfAbsent(key, m -> new HashMap<>()).put((vowelCount % k), 1L);
            }
        }
        return res;
    }
}