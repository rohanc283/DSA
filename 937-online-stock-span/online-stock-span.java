class StockSpanner {
    class Stock {
        public int price;
        public int span;

        Stock(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    Deque<Stock> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        Stock stock = new Stock(price, 1);
        while (!stack.isEmpty() && stack.peek().price <= price) {
            stock.span += stack.pop().span;
        }
        stack.push(stock);
        return stock.span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */