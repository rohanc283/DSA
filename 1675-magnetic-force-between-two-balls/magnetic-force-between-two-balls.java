class Solution {
    private boolean isPoss(int[] position, int m, int dis) {
        int prevBallIdx = 0;
        int currBalls = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - position[prevBallIdx] >= dis) {
                prevBallIdx = i;
                currBalls++;
            }
        }
        return currBalls >= m;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int l = 1, h = position[n - 1] - position[0];
        int res = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPoss(position, m, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return res;
    }
}