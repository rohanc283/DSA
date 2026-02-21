class Solution {
    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {

        List<Integer>[] buckets = new ArrayList[101];
        for (int i = 0; i <= 100; i++)
            buckets[i] = new ArrayList<>();

        for (int[] rect : rectangles)
            buckets[rect[1]].add(rect[0]);

        for (int i = 0; i <= 100; i++)
            Collections.sort(buckets[i]);

        int[] res = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int count = 0;

            for (int h = y; h <= 100; h++) {
                List<Integer> widths = buckets[h];
                if (widths.isEmpty())
                    continue;

                int idx = lowerBound(widths, x);
                count += widths.size() - idx;
            }

            res[i] = count;
        }

        return res;
    }

}