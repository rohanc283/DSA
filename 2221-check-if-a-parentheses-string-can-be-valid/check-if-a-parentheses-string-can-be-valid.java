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

    public boolean canBeValid(String s, String locked) {
        return sol1(s, locked);
    }
}