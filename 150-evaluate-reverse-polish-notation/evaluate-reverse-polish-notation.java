class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                int val = Integer.parseInt(token);
                stack.push(val);
            } else {
                int second = stack.pop(), first = stack.pop();
                if (token.equals("+")) {
                    stack.push(first + second);
                } else if (token.equals("-")) {
                    stack.push(first - second);
                } else if (token.equals("*")) {
                    stack.push(first * second);
                } else {
                    stack.push(first / second);
                }
            }
        }
        return stack.pop();
    }
}