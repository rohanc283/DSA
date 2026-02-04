class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        for (int t : time) {
            int rem = t % 60;
            if (rem == 0) {
                if (map.containsKey(60)) {
                    pairs += map.get(60);
                }
                map.put(60, map.getOrDefault(60, 0) + 1);
            } else {
                if (map.containsKey(60 - rem))
                    pairs += map.get(60 - rem);
                map.put(rem, map.getOrDefault(rem, 0) + 1);
            }
        }
        return pairs;
    }
}