class Solution {
    TreeSet<Integer> minHeap, maxHeap;

    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> cmp = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        minHeap = new TreeSet<>(cmp);
        maxHeap = new TreeSet<>(cmp.reversed());

        int n = nums.length;
        double[] res = new double[n - k + 1];

        int resIdx = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                minHeap.remove(i - k);
                maxHeap.remove(i - k);
            }

            minHeap.add(i);
            maxHeap.add(minHeap.pollFirst());

            balanceHeaps();
            if (i >= k - 1)
                res[resIdx++] = getMedian(nums, k);
        }
        return res;
    }

    public void balanceHeaps() {
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.pollFirst());
        }
    }

    public Double getMedian(int[] nums, int k) {
        if (k % 2 == 0) {
            return ((double) nums[minHeap.first()] + nums[maxHeap.first()]) / 2;
        }
        return (double) nums[minHeap.first()];
    }
}