class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n];

        for (int[] q : shifts) {
            int l = q[0];
            int r = q[1];
            int dir = q[2] == 0 ? -1 : 1;

            diff[l] += dir;
            if (r + 1 < n) {
                diff[r + 1] -= dir;
            }
        }

        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }

        StringBuilder ans = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int shift = diff[i] % 26;
            if (shift < 0)
                shift += 26;

            char c = (char) ('a' + (s.charAt(i) - 'a' + shift) % 26);
            ans.append(c);
        }

        return ans.toString();
    }
}
