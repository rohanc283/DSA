class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback,
            String[] report, int[] student_id, int k) {

        Set<String> pos = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> neg = new HashSet<>(Arrays.asList(negative_feedback));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);

        for (int i = 0; i < report.length; i++) {
            int score = 0;
            for (String word : report[i].split(" ")) {
                if (pos.contains(word))
                    score += 3;
                else if (neg.contains(word))
                    score -= 1;
            }

            pq.offer(new int[] { student_id[i], score });
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[0]);
        }

        Collections.reverse(res);
        return res;
    }
}