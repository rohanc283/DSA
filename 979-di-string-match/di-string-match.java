class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int l = 0, r = n;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                ans[k++] = l++;
            } else {
                ans[k++] = r--;
            }
        }
        ans[k++] = l++;
        return ans;
    }
}