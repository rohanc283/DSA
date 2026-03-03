class Solution {
    public int sol1(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        pq.offer(1L);
        set.add(1L);

        long curr = 1;

        for (int i = 0; i < n; i++) {
            curr = pq.poll();

            long n2 = curr * 2;
            long n3 = curr * 3;
            long n5 = curr * 5;

            if (set.add(n2))
                pq.offer(n2);
            if (set.add(n3))
                pq.offer(n3);
            if (set.add(n5))
                pq.offer(n5);
        }

        return (int) curr;
    }

    public int sol2(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++) {
            int i2Ugly = arr[i2] * 2;
            int i3Ugly = arr[i3] * 3;
            int i5Ugly = arr[i5] * 5;
            int minUgly = Math.min(i2Ugly, Math.min(i3Ugly, i5Ugly));
            arr[i] = minUgly;
            if (i2Ugly == minUgly) {
                i2++;
            }
            if (i3Ugly == minUgly) {
                i3++;
            }
            if (i5Ugly == minUgly) {
                i5++;
            }
        }
        return arr[n];
    }

    public int nthUglyNumber(int n) {
        return sol2(n);
    }
}