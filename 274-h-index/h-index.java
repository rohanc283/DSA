class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int bucket[] = new int[n + 1];
        for (int cit : citations) {
            if (cit > n)
                bucket[n]++;
            else
                bucket[cit]++;
        }

        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (count >= i)
                return i;
        }
        return count;
    }
}