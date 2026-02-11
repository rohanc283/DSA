class MinStack {

    Deque<Long> dq;
    long mini = Integer.MAX_VALUE;

    public MinStack() {
        dq = new ArrayDeque<>();
    }

    public void push(int val) {
        long x = val;

        if (dq.isEmpty()) {
            dq.push(x);
            mini = x;
        } else if (x >= mini) {
            dq.push(x);
        } else {
            dq.push(2 * x - mini);
            mini = x;
        }
    }

    public void pop() {
        if (dq.isEmpty())
            return;

        long top = dq.pop();

        if (top < mini) {
            mini = 2 * mini - top;
        }
    }

    public int top() {
        long top = dq.peek();
        if (top < mini)
            return (int) mini;
        return (int) top;
    }

    public int getMin() {
        return dq.isEmpty() ? -1 : (int) mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */