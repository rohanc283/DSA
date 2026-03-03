class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    int diff = Math.abs(b - x) - Math.abs(a - x);
                    if (diff == 0) {
                        return b - a;
                    }
                    return diff;
                });
        for (int num : arr) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> res = new ArrayList<>(pq);
        Collections.sort(res);
        return res;
    }
}