class Solution {
    public boolean isSubseq(String s, String p, int[] removable, int m) {
        int n = s.length();
        boolean[] isRemoved = new boolean[n];
        for (int i = 0; i <= m; i++) {
            isRemoved[removable[i]] = true;
        }
        int i = 0, j = 0;
        while (i < n && j < p.length()) {
            if (isRemoved[i]) {
                i++;
                continue;
            }
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j >= p.length();
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, h = removable.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isSubseq(s, p, removable, m)) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l;
    }
}