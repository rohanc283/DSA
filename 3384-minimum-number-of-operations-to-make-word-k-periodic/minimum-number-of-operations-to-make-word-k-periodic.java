class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i += k) {
            String block = word.substring(i, i + k);
            map.put(block, map.getOrDefault(block, 0) + 1);
        }

        int maxFreq = 0;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int totalBlocks = word.length() / k;
        return totalBlocks - maxFreq;
    }
}