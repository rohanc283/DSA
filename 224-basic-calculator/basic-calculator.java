class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 0, result = 0, sign = 1;
        for (char c : s.toCharArray()) {
            if (c == ' ')
                continue;
            else if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += (number * sign);
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += (number * sign);
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else {
                result += (number * sign);
                number = 0;
                sign = 1;

                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = (prevResult + (result * prevSign));
            }
        }
        result += (number * sign);
        return result;
    }
}