class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = 1 << k;
        int matches = 0;
        int curr = 0, mask = n - 1;
        boolean[] seen = new boolean[n];
        for (int i = 0; i < s.length(); i++) {
            curr = (curr << 1) | (s.charAt(i) - '0');
            curr &= mask;
            if (i >= k - 1) {
                if (!seen[curr]) {
                    seen[curr] = true;
                    matches++;
                    if (matches == n)
                        return true;
                }
            }
        }
        return matches == n;
    }
}