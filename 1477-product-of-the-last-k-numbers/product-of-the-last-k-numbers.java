class ProductOfNumbers {

    List<Integer> productArr;
    int lastZeroIdx = -1;

    public ProductOfNumbers() {
        productArr = new ArrayList<>();
    }

    public void add(int num) {
        int n = productArr.size();
        if (num == 0) {
            lastZeroIdx = n;
            productArr.add(num);
        } else if (n == 0 || productArr.get(n - 1) == 0) {
            productArr.add(num);
        } else {
            productArr.add(num * productArr.get(n - 1));
        }
    }

    public int getProduct(int k) {
        int n = productArr.size();
        int idx = n - k - 1;
        if (lastZeroIdx > idx)
            return 0;
        if (idx == -1 || productArr.get(idx) == 0)
            return productArr.get(n - 1);
        return productArr.get(n - 1) / productArr.get(idx);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */