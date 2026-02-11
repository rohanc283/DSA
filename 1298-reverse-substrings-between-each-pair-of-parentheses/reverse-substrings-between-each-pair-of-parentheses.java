class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')') {
                dq.addLast(s.charAt(i));
            } else {
                StringBuilder curr = new StringBuilder();
                while (!dq.isEmpty() && dq.peekLast() != '(') {
                    curr.append(dq.peekLast());
                    dq.removeLast();
                }
                if (!dq.isEmpty())
                    dq.removeLast();
                for (int j = 0; j < curr.length(); j++) {
                    dq.addLast(curr.charAt(j));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!dq.isEmpty()) {
            res.append(dq.peekLast());
            dq.removeLast();
        }
        return res.reverse().toString();
    }
}