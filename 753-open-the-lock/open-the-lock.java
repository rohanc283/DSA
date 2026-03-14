class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000"))
            return -1;

        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");
        dead.add("0000");

        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(target))
                    return moves;

                char[] arr = curr.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char original = arr[j];

                    arr[j] = (char) ((original - '0' + 1) % 10 + '0');
                    String next = new String(arr);

                    if (!dead.contains(next)) {
                        dead.add(next);
                        q.offer(next);
                    }

                    arr[j] = (char) ((original - '0' + 9) % 10 + '0');
                    String prev = new String(arr);
                    if (!dead.contains(prev)) {
                        dead.add(prev);
                        q.offer(prev);
                    }

                    arr[j] = original;
                }
            }

            moves++;
        }
        return -1;
    }
}