class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int i = 0, j = height.length - 1;
        int water = 0;
        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax)
                water += leftMax - height[i++];
            else
                water += rightMax - height[j--];
        }
        return water;
    }
}