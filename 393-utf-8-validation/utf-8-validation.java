class Solution {
    public boolean validUtf8(int[] data) {
        int one = 0, two = 6, three = 14, four = 30;
        int nextRemBit = 0;
        for (int d : data) {
            d = d & 255;
            if (nextRemBit > 0) {
                if (d >> 6 != 2)
                    return false;
                nextRemBit--;
            } else if (d >> 7 == one) {
                nextRemBit = 0;
            } else if (d >> 5 == two) {
                nextRemBit = 1;
            } else if (d >> 4 == three) {
                nextRemBit = 2;
            } else if (d >> 3 == four) {
                nextRemBit = 3;
            } else {
                return false;
            }
        }
        return nextRemBit == 0;
    }
}