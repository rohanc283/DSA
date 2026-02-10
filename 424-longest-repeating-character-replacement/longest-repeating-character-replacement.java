class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;

        int[] freq = new int[26];
        int res = 0;
        int maxi = 0;
        while (j < n) {
            char c = s.charAt(j);
            freq[c - 'A']++;
            maxi = Math.max(maxi, freq[c - 'A']);
            while ((j - i + 1) - maxi > k && i < j) {
                freq[s.charAt(i) - 'A']--;
                maxi = Math.max(maxi, freq[s.charAt(i) - 'A']);
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}