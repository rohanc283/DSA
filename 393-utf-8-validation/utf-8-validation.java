class Solution {
    public boolean validUtf8(int[] data) {
        int nextRemBit = 0;
        int one = 0, two = 6, three = 14, four = 30;
        int i = 0;

        while (i < data.length) {
            int num = data[i] & 255;

            if (nextRemBit > 0) {
                if ((num >> 6) != 2)
                    return false;
                nextRemBit--;
            } else if ((num >> 7) == one) {
                nextRemBit = 0;
            } else if ((num >> 5) == two) {
                nextRemBit = 1;
            } else if ((num >> 4) == three) {
                nextRemBit = 2;
            } else if ((num >> 3) == four) {
                nextRemBit = 3;
            } else {
                return false;
            }
            i++;
        }
        return nextRemBit == 0;
    }
}
