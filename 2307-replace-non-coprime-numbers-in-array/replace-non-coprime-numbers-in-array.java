class Solution {
    public int findGcd(int a, int b) {
        while (b > 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
            while (res.size() >= 2) {
                int a = res.get(res.size() - 2);
                int b = res.get(res.size() - 1);
                int gcd = findGcd(a, b);
                if (gcd == 1)
                    break;
                int lcm = (int) (((long) a * (long) b) / gcd);
                res.remove(res.size() - 1);
                res.set(res.size() - 1, lcm);
            }
        }
        return res;
    }
}