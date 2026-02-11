class Solution {
    public int sol1(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                deque.addLast(c);
            } else {
                if (!deque.isEmpty() && deque.peekLast() == '(') {
                    deque.removeLast();
                } else {
                    deque.addLast(c);
                }
            }
        }
        return deque.size();
    }

    public int sol2(String s) {
        int open = 0, close = 0;
        boolean add = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                add = true;
            } else {
                if (add) {
                    open--;
                    if (open == 0)
                        add = false;
                } else {
                    close++;
                    add = false;
                }
            }
        }
        return open + close;
    }

    public int minAddToMakeValid(String s) {
        return sol2(s);
    }
}