class Solution {
    public boolean sol1(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0)
            return false;
        Deque<Integer> open = new ArrayDeque<>();
        Deque<Integer> openClose = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                openClose.addLast(i);
            } else if (s.charAt(i) == '(') {
                open.addLast(i);
            } else {
                if (!open.isEmpty()) {
                    open.removeLast();
                } else if (!openClose.isEmpty()) {
                    openClose.removeLast();
                } else {
                    return false;
                }
            }
        }
        while (!open.isEmpty() && !openClose.isEmpty() && open.peekLast() < openClose.peekLast()) {
            open.removeLast();
            openClose.removeLast();
        }
        return open.isEmpty();
    }

    public boolean sol2(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0)
            return false;
        int open = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0')
                open++;
            else
                open--;
            if (open < 0)
                return false;
        }
        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0')
                close++;
            else
                close--;
            if (close < 0)
                return false;
        }
        return true;
    }

    public boolean canBeValid(String s, String locked) {
        return sol2(s, locked);
    }
}