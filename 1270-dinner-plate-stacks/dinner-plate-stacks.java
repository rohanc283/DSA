class DinnerPlates {

    List<Deque<Integer>> stacks;
    TreeSet<Integer> available;
    int capacity;
    int rightMost;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        available = new TreeSet<>();
        rightMost = -1;
    }

    public void push(int val) {
        while (!available.isEmpty() && available.first() >= stacks.size())
            available.pollFirst();

        int index;
        if (!available.isEmpty()) {
            index = available.first();
        } else {
            index = stacks.size();
            stacks.add(new ArrayDeque<>());
        }

        stacks.get(index).push(val);
        if (stacks.get(index).size() >= capacity) {
            available.remove(index);
        } else {
            available.add(index);
        }

        rightMost = Math.max(rightMost, index);
    }

    public int pop() {
        while (rightMost >= 0 && rightMost >= stacks.size() && stacks.get(rightMost).isEmpty())
            rightMost--;

        if (rightMost < 0)
            return -1;
        return popAtStack(rightMost);
    }

    public int popAtStack(int index) {
        if (index >= stacks.size() || stacks.get(index).isEmpty())
            return -1;
        int val = stacks.get(index).pop();
        available.add(index);
        if (index == rightMost && stacks.get(index).isEmpty()) {
            while (rightMost >= 0 && stacks.get(rightMost).isEmpty())
                rightMost--;
        }
        return val;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */