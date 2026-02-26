class Solution {
    public void banSenator(String senate, char senator, boolean[] isBanned, int idx, int n) {
        while (true) {
            if (senate.charAt(idx) == senator && !isBanned[idx]) {
                isBanned[idx] = true;
                break;
            }
            idx = (idx + 1) % n;
        }
    }

    public String sol1(String senate) {
        int n = senate.length();
        boolean[] isBanned = new boolean[n];
        int rCount = 0, dCount = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R')
                rCount++;
            else
                dCount++;
        }
        int idx = 0;
        while (rCount > 0 && dCount > 0) {
            if (isBanned[idx]) {
                idx = (idx + 1) % n;
                continue;
            }
            if (senate.charAt(idx) == 'R') {
                banSenator(senate, 'D', isBanned, (idx + 1) % n, n);
                dCount--;
            } else {
                banSenator(senate, 'R', isBanned, (idx + 1) % n, n);
                rCount--;
            }
            idx = (idx + 1) % n;
        }
        return rCount == 0 ? "Dire" : "Radiant";
    }

    public String sol2(String senate) {
        int n = senate.length();
        Queue<Integer> rQueue = new ArrayDeque<>();
        Queue<Integer> dQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R')
                rQueue.offer(i);
            else
                dQueue.offer(i);
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.poll();
            int d = dQueue.poll();
            if (r < d) {
                rQueue.offer(r + n);
            } else {
                dQueue.offer(d + n);
            }
        }
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }

    public String predictPartyVictory(String senate) {
        return sol2(senate);
    }
}