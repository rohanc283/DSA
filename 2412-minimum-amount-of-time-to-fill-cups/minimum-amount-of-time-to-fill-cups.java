class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(amount[0]);
        maxHeap.offer(amount[1]);
        maxHeap.offer(amount[2]);
        int time = 0;
        while (!maxHeap.isEmpty()) {
            int cup1Amount = maxHeap.poll();
            int cup2Amount = maxHeap.poll();
            if (cup1Amount == 0 || cup2Amount == 0) {
                time += (cup1Amount + cup2Amount);
                return time;
            } else {
                time++;
                cup1Amount--;
                cup2Amount--;
                maxHeap.offer(cup1Amount);
                maxHeap.offer(cup2Amount);
            }
        }
        return 0;
    }
}