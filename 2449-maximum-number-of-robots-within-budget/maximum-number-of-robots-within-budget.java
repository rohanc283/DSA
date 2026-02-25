class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> maxDq = new ArrayDeque<>();
        int n = chargeTimes.length;
        int l = 0, r = 0;
        long runningSum = 0;
        int maxRobots = 0;
        while (r < n) {
            while (!maxDq.isEmpty() && chargeTimes[maxDq.getLast()] <= chargeTimes[r]) {
                maxDq.removeLast();
            }
            maxDq.addLast(r);
            runningSum += runningCosts[r];
            while (!maxDq.isEmpty() && (chargeTimes[maxDq.getFirst()] + (r - l + 1) * runningSum) > budget) {
                if (!maxDq.isEmpty() && maxDq.getFirst() == l) {
                    maxDq.removeFirst();
                }
                runningSum -= runningCosts[l];
                l++;
            }
            maxRobots = Math.max(maxRobots, r - l + 1);
            r++;
        }
        return maxRobots;
    }
}