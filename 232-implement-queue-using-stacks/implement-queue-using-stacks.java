class MyQueue {
    Deque<Integer> st1, st2;

    public MyQueue() {
        st1 = new ArrayDeque<>();
        st2 = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!st1.isEmpty()) {
            st2.addLast(st1.getLast());
            st1.removeLast();
        }
        st1.addLast(x);
        while (!st2.isEmpty()) {
            st1.addLast(st2.getLast());
            st2.removeLast();
        }
    }

    public int pop() {
        if (st1.isEmpty())
            return -1;
        int val = st1.getLast();
        st1.removeLast();
        return val;
    }

    public int peek() {
        if (st1.isEmpty())
            return -1;
        return st1.getLast();
    }

    public boolean empty() {
        return st1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */