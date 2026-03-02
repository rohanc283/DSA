class SeatManager {

    PriorityQueue<Integer> minHeap;
    int nextSeat;

    public SeatManager(int n) {
        minHeap = new PriorityQueue<>();
        nextSeat = 1;
    }

    public int reserve() {
        if (!minHeap.isEmpty()) {
            return minHeap.poll();
        }
        return nextSeat++;
    }

    public void unreserve(int seatNumber) {
        minHeap.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */