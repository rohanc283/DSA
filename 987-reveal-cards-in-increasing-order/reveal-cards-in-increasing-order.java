class Solution {
    public int[] sol1(int[] deck) {
        boolean skip = false;
        int n = deck.length;
        int[] res = new int[n];
        int i = 0, j = 0;
        while (i < n) {
            if (res[j] == 0) {
                if (skip) {
                    skip = false;
                } else {
                    res[j] = deck[i++];
                    skip = true;
                }
            }
            j = (j + 1) % n;
        }
        return res;
    }

    public int[] sol2(int[] deck) {
        int n = deck.length;
        int[] res = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            queue.offer(i);
        for (int i = 0; i < n; i++) {
            res[queue.poll()] = deck[i];
            if (!queue.isEmpty())
                queue.offer(queue.poll());
        }
        return res;
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        return sol2(deck);
    }
}