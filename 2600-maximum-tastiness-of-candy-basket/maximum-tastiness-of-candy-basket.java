class Solution {
    private boolean isPoss(int[] price, int k, int dis) {
        int prevBallIdx = 0;
        int currBalls = 1;
        for (int i = 1; i < price.length; i++) {
            if (price[i] - price[prevBallIdx] >= dis) {
                prevBallIdx = i;
                currBalls++;
            }
        }
        return currBalls >= k;
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int l = 1, h = price[n - 1] - price[0];
        int res = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPoss(price, k, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return res;
    }
}