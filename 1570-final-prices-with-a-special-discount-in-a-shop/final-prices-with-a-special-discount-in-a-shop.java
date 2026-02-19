class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = prices.length - 1; i >= 0; i--) {
            while (stack.peek() != -1 && prices[i] < stack.peek()) {
                stack.pop();
            }
            int price = prices[i];
            if (stack.peek() != -1) {
                prices[i] -= stack.peek();
            }
            stack.push(price);
        }
        return prices;
    }
}