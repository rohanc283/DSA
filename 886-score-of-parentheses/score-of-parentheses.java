class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        stack.push(res);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(0);
            } else {
                int val = 0;
                while (!stack.isEmpty() && stack.peek() != 0) {
                    val += stack.peek();
                    stack.pop();
                }
                stack.pop();
                stack.push(val == 0 ? 1 : 2 * val);
            }
        }
        while (!stack.isEmpty()) {
            res += stack.peek();
            stack.pop();
        }
        return res;
    }
}