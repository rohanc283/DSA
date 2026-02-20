class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxi = Integer.MIN_VALUE, leftMaxiIdx = -1;
        for (int i = 0; i < n; i++) {
            if (height[i] > maxi) {
                maxi = height[i];
                leftMaxiIdx = i;
            }
        }
        int leftMax = 0;
        int res = 0;
        for (int i = 0; i <= leftMaxiIdx; i++) {
            if (leftMax > height[i]) {
                res += (leftMax - height[i]);
            }
            leftMax = Math.max(leftMax, height[i]);
        }

        maxi = Integer.MIN_VALUE;
        int rightMaxiIdx = -1;
        for (int i = 0; i < n; i++) {
            if (height[i] > maxi) {
                maxi = height[i];
                rightMaxiIdx = i;
            }
        }
        int rightMax = 0;
        for (int i = n - 1; i >= rightMaxiIdx; i--) {
            if (rightMax > height[i]) {
                res += (rightMax - height[i]);
            }
            rightMax = Math.max(rightMax, height[i]);
        }
        return res;
    }
}