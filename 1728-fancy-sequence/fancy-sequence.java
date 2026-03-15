class Fancy {
    long M = 1_000_000_007;
    List<Long> seq;
    long add, multi;

    public Fancy() {
        seq = new ArrayList<>();
        add = 0;
        multi = 1;
    }

    public void append(int val) {
        long x = ((val - add + M) % M) * power(multi, M - 2) % M;
        seq.add(x);
    }

    public void addAll(int inc) {
        add = (add + inc) % M;
    }

    public void multAll(int m) {
        multi = (multi * m) % M;
        add = (add * m) % M;
    }

    public int getIndex(int idx) {
        if (idx >= seq.size())
            return -1;

        long val = seq.get(idx);
        return (int)((val * multi + add) % M);
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= M;

        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % M;
            base = (base * base) % M;
            exp >>= 1;
        }
        return res;
    }
}