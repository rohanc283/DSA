class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
            int[] student_id, int k) {
        Set<String> positiveFeedbackSet = new HashSet<>();
        Set<String> negativeFeedbackSet = new HashSet<>();
        for (String posFeed : positive_feedback) {
            positiveFeedbackSet.add(posFeed);
        }
        for (String negFeed : negative_feedback) {
            negativeFeedbackSet.add(negFeed);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);
        for (int i = 0; i < report.length; i++) {
            int score = 0;
            String[] words = report[i].split(" ");
            for (String word : words) {
                if (positiveFeedbackSet.contains(word)) {
                    score += 3;
                } else if (negativeFeedbackSet.contains(word)) {
                    score--;
                }
            }
            pq.offer(new int[] { student_id[i], score });
        }
        List<Integer> res = new ArrayList<>();
        while (k-- > 0) {
            res.add(pq.poll()[0]);
        }
        return res;
    }
}