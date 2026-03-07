class Solution {
    Map<Integer, Integer> map;
    int n;
    Integer[][] dp;

    public boolean solve(int[] stones, int currStoneIdx, int prevJump) {
        if (currStoneIdx == n - 1)
            return true;
        if (dp[currStoneIdx][prevJump] != null)
            return dp[currStoneIdx][prevJump] == 1 ? true : false;
        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0) {
                int nextStone = stones[currStoneIdx] + nextJump;
                if (map.containsKey(nextStone)) {
                    boolean ans = solve(stones, map.get(nextStone), nextJump);
                    if (ans) {
                        dp[currStoneIdx][prevJump] = 1;
                        return ans;
                    }
                }
            }
        }
        dp[currStoneIdx][prevJump] = 0;
        return false;
    }

    public boolean canCross(int[] stones) {
        if (stones[1] != 1)
            return false;
        n = stones.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        dp = new Integer[2001][2001];
        return solve(stones, 0, 0);
    }
}