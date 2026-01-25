class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> ans = new ArrayList<>();

        int[] nonIncreasingLeft = new int[n];
        int[] nonDecreasingRight = new int[n];

        // Count non-increasing days to the left
        for (int i = 1; i < n; i++) {
            if (security[i - 1] >= security[i]) {
                nonIncreasingLeft[i] = nonIncreasingLeft[i - 1] + 1;
            }
        }

        // Count non-decreasing days to the right
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                nonDecreasingRight[i] = nonDecreasingRight[i + 1] + 1;
            }
        }

        // Check valid days
        for (int i = time; i < n - time; i++) {
            if (nonIncreasingLeft[i] >= time && nonDecreasingRight[i] >= time) {
                ans.add(i);
            }
        }

        return ans;
    }
}
