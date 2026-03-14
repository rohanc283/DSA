class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int val : row)
                start.append(val);
        }

        String dest = "123450";

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start.toString());
        visited.add(start.toString());

        int moves = 0;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(dest))
                    return moves;
                int zeroIdx = curr.indexOf('0');

                int r = zeroIdx / 3;
                int c = zeroIdx % 3;

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nc >= 0 && nr < 2 && nc < 3) {
                        int idx = nr * 3 + nc;
                        StringBuilder next = new StringBuilder(curr);
                        char temp = next.charAt(idx);
                        next.setCharAt(idx, '0');
                        next.setCharAt(zeroIdx, temp);

                        String nextStr = next.toString();

                        if (!visited.contains(nextStr)) {
                            visited.add(nextStr);
                            queue.offer(nextStr);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}