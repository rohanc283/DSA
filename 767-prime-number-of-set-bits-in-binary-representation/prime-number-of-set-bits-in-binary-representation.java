class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primes = new HashSet<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);
        int res = 0;
        while (left <= right) {
            int count = Integer.bitCount(left++);
            if (primes.contains(count))
                res++;
        }
        return res;
    }
}