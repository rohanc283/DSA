class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int l = 0, r = n;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                res[i] = l++;
            } else {
                res[i] = r--;
            }
        }
        res[n] = l;
        return res;
    }
}