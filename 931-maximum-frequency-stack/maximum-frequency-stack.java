class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Deque<Integer>> freqStack;
    int maxFreq = Integer.MIN_VALUE;

    public FreqStack() {
        freq = new HashMap<>();
        freqStack = new HashMap<>();
    }

    public void push(int val) {
        int currFreq = freq.getOrDefault(val, 0) + 1;
        freq.put(val, currFreq);
        freqStack.computeIfAbsent(currFreq, d -> new ArrayDeque<>()).push(val);
        maxFreq = Math.max(maxFreq, currFreq);
    }

    public int pop() {
        int val = freqStack.get(maxFreq).peek();
        freqStack.get(maxFreq).pop();
        if (freqStack.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        freq.put(val, freq.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */