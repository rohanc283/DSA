class ProductOfNumbers {

    List<Integer> productArr;

    public ProductOfNumbers() {
        productArr = new ArrayList<>();
        productArr.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            productArr.clear();
            productArr.add(1);
        } else {
            productArr.add(num * productArr.get(productArr.size() - 1));
        }
    }

    public int getProduct(int k) {
        int n = productArr.size();
        if (k >= n)
            return 0;
        return productArr.get(n - 1) / productArr.get(n - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */