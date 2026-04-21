class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length, n = bank[0].length();
        int[] beams = new int[m];
        for (int i = 0; i < m; i++) {
            for (char c : bank[i].toCharArray()) {
                if (c == '1') {
                    beams[i]++;
                }
            }
        }
        int res = 0;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (beams[i] > 0) {
                if (prev != -1) {
                    res += (beams[prev] * beams[i]);
                }
                prev = i;
            }
        }
        return res;
    }
}