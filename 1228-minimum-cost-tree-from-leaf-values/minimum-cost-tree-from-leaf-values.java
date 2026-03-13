class Solution {
    Map<String, Integer> map;
    Integer[][] dp;

    private int solve(int[] arr, int i, int j) {
        if (i >= j)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            String key1 = i + "#" + k;
            String key2 = (k + 1) + "#" + j;
            int curr = map.get(key1) * map.get(key2) + solve(arr, i, k) + solve(arr, k + 1, j);
            ans = Math.min(ans, curr);
        }
        return dp[i][j] = ans;
    }

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        map = new HashMap<>();
        dp = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            int maxi = arr[i];
            String key = i + "#" + i;
            map.put(key, maxi);
            for (int j = i + 1; j < n; j++) {
                maxi = Math.max(maxi, arr[j]);
                key = i + "#" + j;
                map.put(key, maxi);
            }
        }
        return solve(arr, 0, n - 1);
    }
}