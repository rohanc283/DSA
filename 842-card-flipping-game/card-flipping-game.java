class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> blacklisted = new HashSet<>();

        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i])
                blacklisted.add(fronts[i]);
            else
                set.add(backs[i]);
        }

        int mini = Integer.MAX_VALUE;
        for (int f : fronts) {
            if (blacklisted.contains(f))
                continue;
            if (!set.contains(f)) {
                mini = Math.min(mini, f);
            }
        }
        for (int f : backs) {
            if (blacklisted.contains(f))
                continue;
            mini = Math.min(mini, f);
        }
        return mini == Integer.MAX_VALUE ? 0 : mini;
    }
}