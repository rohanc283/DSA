class MyCircularDeque {

    int[] queue;
    int f = -1, r = -1, s = 0;

    public MyCircularDeque(int k) {
        s = k;
        queue = new int[s];
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        if (isEmpty()) {
            f = r = 0;
        } else if (f == 0) {
            f = s - 1;
        } else {
            f--;
        }
        queue[f] = value;
        return true;
    }

    public boolean insertLast(int value) {
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

    public boolean deleteFront() {
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

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        if (f == r) {
            f = r = -1;
        } else if (r == 0) {
            r = s - 1;
        } else {
            r--;
        }
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return queue[f];
    }

    public int getRear() {
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
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */