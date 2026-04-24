class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[][] freq = new int[n][26];

        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                freq[i][c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            int count = 0;
            boolean isPresent = false;
            for (int j = 0; j < n; j++) {
                count += freq[j][i];
                if (freq[j][i] > 0)
                    isPresent = true;
            }
            if (isPresent && (count % n != 0))
                return false;
        }
        return true;
    }
}