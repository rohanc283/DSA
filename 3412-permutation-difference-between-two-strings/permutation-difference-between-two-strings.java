class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }
        int res = 0;
        for (int i = 0; i < t.length(); i++) {
            res += Math.abs(i - index[t.charAt(i) - 'a']);
        }
        return res;
    }
}