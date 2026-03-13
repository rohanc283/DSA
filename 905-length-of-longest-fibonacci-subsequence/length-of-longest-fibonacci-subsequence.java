class Solution {
    Map<Integer, Integer> map;
    Integer[][] dp;

    private int solve(int[] arr, int j, int k) {
        if (dp[j][k] != null)
            return dp[j][k];
        int rem = arr[k] - arr[j];
        if (map.containsKey(rem) && map.get(rem) < j) {
            return dp[j][k] = 1 + solve(arr, map.get(rem), j);
        }
        return dp[j][k] = 0;
    }

    public int lenLongestFibSubseq(int[] arr) {
        map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int maxLen = 0;
        dp = new Integer[n][n];
        for (int k = 2; k < n; k++) {
            for (int j = 1; j < k; j++) {
                maxLen = Math.max(maxLen, 2 + solve(arr, j, k));
            }
        }
        return maxLen > 2 ? maxLen : 0;
    }
}