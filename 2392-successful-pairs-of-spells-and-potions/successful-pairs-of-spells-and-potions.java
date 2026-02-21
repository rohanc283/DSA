class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            int s = 0, e = m - 1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                long v = potions[mid] * spell;
                if (v >= success) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
            res[i] = m - s;
        }
        return res;
    }
}