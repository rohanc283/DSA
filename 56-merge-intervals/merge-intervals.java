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

    public int[][] merge(int[][] intervals) {
        sortIntervals(intervals);
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        res.add(intervals[i++]);
        while (i < n) {
            if (res.get(res.size() - 1)[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
            }
            i++;
        }
        return buildOutput(res);
    }
}