class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length())
            return "0";
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && c < stack.peek()) {
                stack.pop();
                k--;
            }
            if (stack.size() > 0 || c != '0')
                stack.push(c);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.append(stack.pop());
        if (res.length() == 0) {
            res.append("0");
        }
        return res.reverse().toString();
    }
}