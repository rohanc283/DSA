class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for (int num : citations) {
            if (num >= n) {
                bucket[n]++;
            } else {
                bucket[num]++;
            }
        }
        int cit = 0;
        for (int i = n; i >= 0; i--) {
            cit += bucket[i];
            if (cit >= i)
                return i;
        }
        return 0;
    }
}