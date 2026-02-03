class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;

            freq[i]--;

            int target = 0;
            boolean ok = true;

            for (int f : freq) {
                if (f == 0)
                    continue;
                if (target == 0) {
                    target = f;
                } else if (f != target) {
                    ok = false;
                    break;
                }
            }

            freq[i]++;

            if (ok)
                return true;
        }
        return false;
    }
}
