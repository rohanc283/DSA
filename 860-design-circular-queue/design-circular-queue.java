class MyCircularQueue {

    int[] queue;
    int f = -1, r = -1, s = 0;

    public MyCircularQueue(int k) {
        s = k;
        queue = new int[s];
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        if (isEmpty()) {
            f = r = 0;
        } else if (r == s - 1) {
            r = 0;
        } else {
            r++;
        }
        queue[r] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        if (f == r) {
            f = r = -1;
        } else if (f == s - 1) {
            f = 0;
        } else {
            f++;
        }
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return queue[f];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return queue[r];
    }

    public boolean isEmpty() {
        return f == -1 && r == -1;
    }

    public boolean isFull() {
        return (f == 0 && r == s - 1) || r == f - 1;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */