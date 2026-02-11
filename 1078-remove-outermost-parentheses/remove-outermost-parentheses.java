class Solution {
    public String removeOuterParentheses(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (deque.size() > 0) {
                    res.append(c);
                }
                deque.addLast(c);
            } else {
                if (deque.isEmpty())
                    break;
                if (deque.size() > 1) {
                    res.append(c);
                }
                deque.removeLast();
            }
        }
        return res.toString();
    }
}