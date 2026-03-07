class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        if (n <= 1)
            return n;
        Map<Integer, Integer> dp = new HashMap<>();
        int len = 0;
        for (int i = 0; i < n; i++) {
            int x = arr[i] - difference;
            if (dp.containsKey(x)) {
                dp.put(arr[i], 1 + dp.get(x));
            } else {
                dp.put(arr[i], 1);
            }
            len = Math.max(len, dp.get(arr[i]));
        }
        return len;
    }
}