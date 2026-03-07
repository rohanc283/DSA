class Solution {
    List<Integer> vals;
    Map<Integer, Long> points;
    Long[] dp;

    public long solve(int i) {
        if (i >= vals.size())
            return 0;
        if (dp[i] != null)
            return dp[i];
        int curr = vals.get(i);
        long skip = solve(i + 1);
        int j = i;
        while (j < vals.size() && vals.get(j) <= curr + 2) {
            j++;
        }
        long take = points.get(curr) + solve(j);
        return dp[i] = Math.max(skip, take);
    }

    public long maximumTotalDamage(int[] power) {
        points = new HashMap<>();

        for (int p : power)
            points.put(p, points.getOrDefault(p, 0L) + p);

        vals = new ArrayList<>(points.keySet());
        Collections.sort(vals);

        dp = new Long[vals.size()];

        return solve(0);
    }
}