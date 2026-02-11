class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                dq.addLast(i);
            } else if (s.charAt(i) == ')') {
                if (!dq.isEmpty() && s.charAt(dq.peekLast()) == '(') {
                    dq.removeLast();
                } else {
                    dq.addLast(i);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (!dq.isEmpty() && dq.peekLast() == i) {
                dq.removeLast();
                continue;
            }
            res.append(s.charAt(i));
        }
        res.reverse();
        return res.toString();
    }
}