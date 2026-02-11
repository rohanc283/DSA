class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ')') {
                dq.addLast(c);
            } else {
                StringBuilder curr = new StringBuilder();
                while (!dq.isEmpty() && dq.peekLast() != '(') {
                    curr.append(dq.removeLast());
                }
                dq.removeLast();
                for (int i = 0; i < curr.length(); i++) {
                    dq.addLast(curr.charAt(i));
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!dq.isEmpty()) {
            res.append(dq.removeFirst());
        }

        return res.toString();
    }
}