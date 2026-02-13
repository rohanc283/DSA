class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        if (n == 0)
            return asteroids;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int ast : asteroids) {
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                int sum = ast + stack.peek();
                if (sum < 0) {
                    stack.pop();
                } else if (sum > 0) {
                    ast = 0;
                } else {
                    ast = 0;
                    stack.pop();
                }
            }
            if (ast != 0) {
                stack.push(ast);
            }
        }
        n = stack.size();

        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}