class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        while (size > 0) {
            queue.add(queue.poll());
            size--;
        }
    }

    public int pop() {
        if (!queue.isEmpty())
            return queue.poll();
        return -1;
    }

    public int top() {
        if (!queue.isEmpty())
            return queue.peek();
        return -1;
    }

    public boolean empty() {
        return queue.size() <= 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */