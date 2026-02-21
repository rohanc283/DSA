class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] maxBeauty = new int[items.length];
        maxBeauty[0] = items[0][1];
        for (int i = 1; i < items.length; i++) {
            maxBeauty[i] = Math.max(items[i][1], maxBeauty[i - 1]);
        }
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int query = queries[i];
            int s = 0, e = items.length - 1;
            int curr = 0;
            while (s <= e) {
                int m = s + (e - s) / 2;
                if (items[m][0] <= query) {
                    curr = maxBeauty[m];
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
            res[i] = curr;
        }
        return res;
    }
}