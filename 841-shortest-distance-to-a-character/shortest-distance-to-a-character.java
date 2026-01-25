class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
                continue;
            }
            int iL = Integer.MAX_VALUE, iR = Integer.MAX_VALUE;
            for (int l = i - 1; l >= 0; l--) {
                if (s.charAt(l) == c) {
                    iL = l;
                    break;
                }
            }
            for (int r = i + 1; r < n; r++) {
                if (s.charAt(r) == c) {
                    iR = r;
                    break;
                }
            }
            int cI = Math.min(Math.abs(i - iL), Math.abs(iR - i));
            ans[i] = cI;
        }
        return ans;
    }
}