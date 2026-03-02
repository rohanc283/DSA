class Solution {
    public String sol1(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
            if (counts[c - 'a'] > (n + 1) / 2)
                return res.toString();
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                maxHeap.offer(new int[] { c, counts[c - 'a'] });
            }
        }
        while (maxHeap.size() > 1) {
            int[] a = maxHeap.poll();
            int[] b = maxHeap.poll();
            res.append((char) a[0]);
            res.append((char) b[0]);
            a[1]--;
            b[1]--;
            if (a[1] > 0) {
                maxHeap.offer(a);
            }
            if (b[1] > 0) {
                maxHeap.offer(b);
            }
        }
        if (!maxHeap.isEmpty()) {
            res.append((char) maxHeap.peek()[0]);
        }
        return res.toString();
    }

    public String reorganizeString(String s) {
        return sol1(s);
    }
}