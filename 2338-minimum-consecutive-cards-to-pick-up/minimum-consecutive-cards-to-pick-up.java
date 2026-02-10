class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length, s = 0;
        Set<Integer> set = new HashSet<>();
        int res = Integer.MAX_VALUE;
        for (int e = 0; e < n; e++) {
            while (set.contains(cards[e])) {
                res = Math.min(res, e - s + 1);
                set.remove(cards[s++]);
            }
            set.add(cards[e]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}