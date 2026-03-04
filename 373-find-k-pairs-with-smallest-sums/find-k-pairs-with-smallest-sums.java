class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0)
            return res;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        Set<String> visited = new HashSet<>();

        pq.offer(new int[] { nums1[0] + nums2[0], 0, 0 });
        visited.add("0#0");

        while (k-- > 0 && !pq.isEmpty()) {

            int[] top = pq.poll();
            int i = top[1], j = top[2];

            res.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < nums1.length) {
                String key = (i + 1) + "#" + j;
                if (!visited.contains(key)) {
                    pq.offer(new int[] {
                            nums1[i + 1] + nums2[j],
                            i + 1,
                            j
                    });
                    visited.add(key);
                }
            }

            if (j + 1 < nums2.length) {
                String key = i + "#" + (j + 1);
                if (!visited.contains(key)) {
                    pq.offer(new int[] {
                            nums1[i] + nums2[j + 1],
                            i,
                            j + 1
                    });
                    visited.add(key);
                }
            }
        }

        return res;
    }
}