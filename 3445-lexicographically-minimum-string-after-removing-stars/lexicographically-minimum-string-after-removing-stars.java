class Solution {
    public String clearStars(String s) {
        int n = s.length();
        boolean[] removed = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '*') {
                int[] removedChar = pq.poll();
                removed[removedChar[0]] = true;
                removed[i] = true;
            } else {
                pq.offer(new int[] { i, c });
            }
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (!removed[i] && s.charAt(i) != '*') {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}