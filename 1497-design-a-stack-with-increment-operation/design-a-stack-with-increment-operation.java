class CustomStack {
    int top = -1;
    int[] stack;
    int[] increment;
    int n;

    public CustomStack(int maxSize) {
        n = maxSize;
        stack = new int[n];
        increment = new int[n];
    }

    public void push(int x) {
        if (top == n - 1)
            return;
        stack[++top] = x;
    }

    public int pop() {
        if (top == -1)
            return -1;
        int val = stack[top] + increment[top];
        if (top - 1 >= 0) {
            increment[top - 1] += increment[top];
        }
        increment[top--] = 0;
        return val;
    }

    public void increment(int k, int val) {
        if (top == -1)
            return;
        k--;
        k = k > top ? top : k;
        increment[k] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */