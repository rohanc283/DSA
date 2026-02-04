class Solution {
    public int partitionString(String s) {
        int[] freq = new int[26];
        int j = 0, n = s.length();
        int partition = 1;
        while (j < n) {
            int idx = s.charAt(j) - 'a';
            freq[idx]++;
            if (freq[idx] > 1) {
                partition++;
                Arrays.fill(freq, 0);
                freq[idx]++;
            }
            j++;
        }
        return partition;
    }
}