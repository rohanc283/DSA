class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        Arrays.sort(nums, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long currSum = 0;
        for (int i = 0; i <= k - 1; i++) {
            currSum += nums[i][0];
            pq.offer(nums[i][0]);
        }
        long res = currSum * nums[k - 1][1];
        for (int i = k; i < n; i++) {
            currSum += nums[i][0];
            currSum -= pq.poll();
            pq.offer(nums[i][0]);
            res = Math.max(res, currSum * nums[i][1]);
        }
        return res;
    }
}