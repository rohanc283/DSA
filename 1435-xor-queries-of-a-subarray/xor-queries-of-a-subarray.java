class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int m = arr.length, n = queries.length;
        int[] prefix = new int[m];
        prefix[0] = arr[0];
        for (int i = 1; i < m; i++) {
            prefix[i] = arr[i] ^ prefix[i - 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if (left == 0) {
                res[i] = prefix[right];
            } else {
                res[i] = prefix[right] ^ prefix[left - 1];
            }
        }
        return res;
    }
}