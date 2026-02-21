class Solution {
    class Interval {
        public int start;
        public int end;
        public int pos;

        Interval(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    public int findNextInterval(Interval[] intervals, Interval curr, int s, int e) {
        int res = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            Interval midInterval = intervals[m];
            if (midInterval.start >= curr.end) {
                res = midInterval.pos;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return res;

    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Interval[] allIntervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            allIntervals[i] = new Interval(intervals[i][0], intervals[i][1], i);
        }
        Arrays.sort(allIntervals, (a, b) -> a.start - b.start);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            Interval curr = allIntervals[i];
            res[curr.pos] = findNextInterval(allIntervals, curr, i, n - 1);
        }
        return res;
    }
}