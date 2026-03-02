class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = heights.length;
        for (int i = 0; i < n - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0)
                continue;
            if (bricks >= diff) {
                bricks -= diff;
                maxHeap.offer(diff);
            } else if (ladders > 0) {
                if (!maxHeap.isEmpty() && maxHeap.peek() > diff) {
                    bricks += maxHeap.poll(); // refund largest brick usage
                    bricks -= diff; // use bricks for current
                    maxHeap.offer(diff);
                }
                ladders--;
            } else {
                return i;
            }
        }
        return n - 1;
    }
}