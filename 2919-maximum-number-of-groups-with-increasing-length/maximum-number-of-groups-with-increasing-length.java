class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits, (a, b) -> a - b);
        long total = 0;
        int groups = 0;
        for (int i = 0; i < usageLimits.size(); i++) {
            total += usageLimits.get(i);
            if (total >= (((groups + 1) * (groups + 2)) / 2))
                groups++;
        }
        return groups;
    }
}