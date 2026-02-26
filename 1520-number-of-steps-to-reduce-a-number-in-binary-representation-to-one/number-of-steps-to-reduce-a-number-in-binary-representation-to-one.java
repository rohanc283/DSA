class Solution {
    public int sol1(String s) {

        int op = 0;
        StringBuilder str = new StringBuilder(s);
        while (!(str.length() == 1 && str.charAt(0) == '1')) {
            if (str.charAt(str.length() - 1) == '0') {
                str.deleteCharAt(str.length() - 1);
            } else {
                int j = str.length() - 1;

                while (j >= 0 && str.charAt(j) == '1') {
                    str.setCharAt(j, '0');
                    j--;
                }

                if (j < 0) {
                    str.insert(0, '1');
                } else {
                    str.setCharAt(j, '1');
                }
            }
            op++;
        }
        return op;
    }

    public int sol2(String s) {
        int op = 0;
        int carry = 0;
        StringBuilder str = new StringBuilder(s);
        while (!(str.length() == 1 && str.charAt(0) == '1')) {
            int digit = (str.charAt(str.length() - 1) - '0') + carry;
            if (digit != 1) {
                op++;
                str.deleteCharAt(str.length() - 1);
            } else {
                str.deleteCharAt(str.length() - 1);
                carry = 1;
                op += 2;
            }
        }
        return op + carry;
    }

    public int numSteps(String s) {
        return sol2(s);
    }
}