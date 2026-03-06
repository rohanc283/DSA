class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] freq = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq[c - 'a'] = i;
        }

        int maxReachable = 0;
        int start = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            maxReachable = Math.max(maxReachable, freq[c - 'a']);
            if (i == maxReachable) {
                res.add(maxReachable - start + 1);
                start = i + 1;
                maxReachable = i + 1;
            }
        }
        return res;
    }
}