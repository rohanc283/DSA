class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int maxFreq = 0;
        for (int f : freq.values()) {
            maxFreq = Math.max(maxFreq, f);
        }

        List<List<Character>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxFreq; i++) {
            bucket.add(new ArrayList<>());
        }

        for (char c : freq.keySet()) {
            bucket.get(freq.get(c)).add(c);
        }

        StringBuilder sb = new StringBuilder();

        for (int f = maxFreq; f > 0; f--) {
            for (char c : bucket.get(f)) {
                sb.append(String.valueOf(c).repeat(f));
            }
        }

        return sb.toString();
    }
}
