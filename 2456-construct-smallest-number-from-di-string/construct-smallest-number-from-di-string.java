class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder();
        int n = pattern.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int counter = 0;
        for (int i = 0; i <= n; i++) {
            counter++;
            stack.push(counter);
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    res.append(stack.pop());
                }
            }
        }
        return res.toString();
    }
}