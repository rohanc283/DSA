class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts)
            maxHeap.offer(gift);
        for (int i = 0; i < k; i++) {
            int maxi = maxHeap.poll();
            maxHeap.offer((int) Math.sqrt(maxi));
        }
        long res = 0;
        while (!maxHeap.isEmpty()) {
            res += maxHeap.poll();
        }
        return res;
    }
}