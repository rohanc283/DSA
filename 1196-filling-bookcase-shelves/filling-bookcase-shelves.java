class Solution {
    int totalWidth;
    Integer[][] dp;

    private int solve(int[][] books, int i, int maxHeight, int remainingWidth) {
        if (i >= books.length)
            return maxHeight;
        if (dp[i][remainingWidth] != null)
            return dp[i][remainingWidth];
        int width = books[i][0];
        int height = books[i][1];
        int keep = Integer.MAX_VALUE;
        if (width <= remainingWidth) {
            keep = solve(books, i + 1, Math.max(maxHeight, height), remainingWidth - width);
        }
        int skip = maxHeight + solve(books, i + 1, height, totalWidth - width);
        return dp[i][remainingWidth] = Math.min(keep, skip);
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        totalWidth = shelfWidth;
        dp = new Integer[1001][1001];
        return solve(books, 0, 0, shelfWidth);
    }
}