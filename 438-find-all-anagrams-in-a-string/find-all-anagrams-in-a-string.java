class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n1 = s.length(), n2 = p.length();
        int matches = 26;
        int[] sFreq = new int[matches];
        int[] pFreq = new int[matches];
        for (char c : p.toCharArray()) {
            if (sFreq[c - 'a'] == 0)
                matches--;
            sFreq[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < n1; right++) {
            int rightIdx = s.charAt(right) - 'a';
            pFreq[rightIdx]++;
            if (pFreq[rightIdx] == sFreq[rightIdx]) {
                matches++;
            } else if (pFreq[rightIdx] == sFreq[rightIdx] + 1) {
                matches--;
            }

            if (right >= n2) {
                int leftIdx = s.charAt(left++) - 'a';
                pFreq[leftIdx]--;
                if (pFreq[leftIdx] == sFreq[leftIdx]) {
                    matches++;
                } else if (pFreq[leftIdx] == sFreq[leftIdx] - 1) {
                    matches--;
                }
            }
            if (matches == 26) {
                res.add(right - n2 + 1);
            }
        }
        return res;
    }
}