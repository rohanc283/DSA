class Solution {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();

        int[] prefix = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        int plates = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*')
                plates++;
            prefix[i] = plates;
        }

        int candle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|')
                candle = i;
            left[i] = candle;
        }

        candle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|')
                candle = i;
            right[i] = candle;
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = right[queries[i][0]];
            int r = left[queries[i][1]];

            if (l != -1 && r != -1 && l < r) {
                res[i] = prefix[r] - prefix[l];
            } else {
                res[i] = 0;
            }
        }

        return res;
    }
}