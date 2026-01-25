class Solution {
    public boolean isVowel(String word, int i) {
        char cs = word.charAt(i);
        return cs == 'a' || cs == 'e' || cs == 'i' || cs == 'o' || cs == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int nw = words.length;
        int[] validCount = new int[nw];
        int s = 0;
        for (int i = 0; i < nw; i++) {
            if (isVowel(words[i], 0) && isVowel(words[i], words[i].length() - 1)) {
                s++;
            }
            validCount[i] = s;
        }

        int nq = queries.length;
        int[] ans = new int[nq];
        for (int i = 0; i < nq; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l == 0)
                ans[i] = validCount[r];
            else {
                ans[i] = validCount[r] - validCount[l - 1];
            }
        }
        return ans;
    }
}