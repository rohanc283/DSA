class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int i = 0, j = height.length - 1;
        int water = 0;
        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            int level = Math.min(leftMax, rightMax);
            if (level - height[i] >= 0) {
                water += level - height[i];
            }
            if (level - height[j] >= 0) {
                water += level - height[j];
            }
            if (leftMax <= rightMax)
                i++;
            else if (rightMax < leftMax)
                j--;
        }
        return water;
    }
}