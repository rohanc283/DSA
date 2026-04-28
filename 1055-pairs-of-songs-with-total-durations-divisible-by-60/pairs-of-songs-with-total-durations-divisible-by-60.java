class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int t : time) {
            int rem = t % 60;
            if (rem == 0) {
                res += map.getOrDefault(0, 0);
            } else {
                res += map.getOrDefault(60 - rem, 0);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return res;
    }
}