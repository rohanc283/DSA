class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] startingIndex = new int[26];
        Arrays.fill(startingIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            if (startingIndex[s.charAt(i) - 'a'] == -1) {
                startingIndex[s.charAt(i) - 'a'] = i;
            }
        }
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i > startingIndex[s.charAt(i) - 'a']) {
                res = Math.max(res, i - startingIndex[s.charAt(i) - 'a'] - 1);
            }
        }
        return res;
    }
}