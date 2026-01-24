class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int i = 0, n = height.length, j = n - 1;
        while (i < j) {
            int s = j - i;
            int w = Math.min(height[i], height[j]);
            ans = Math.max(ans, s * w);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}