class Solution {
    public void sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
    }

    public int[][] buildOutput(List<int[]> list) {
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] newIntervals = new int[n + 1][];
        for (int i = 0; i < n; i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[n] = newInterval;
        sortIntervals(newIntervals);
        List<int[]> res = new ArrayList<>();
        int i = 0;
        res.add(newIntervals[i++]);
        while (i <= n) {
            if (res.get(res.size() - 1)[1] < newIntervals[i][0]) {
                res.add(newIntervals[i]);
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], newIntervals[i][1]);
            }
            i++;
        }
        return buildOutput(res);
    }
}