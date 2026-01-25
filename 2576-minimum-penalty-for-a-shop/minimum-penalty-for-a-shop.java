class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0, hour = 0, n = customers.length();
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y')
                penalty++;
        }

        int currPenalty = penalty;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                currPenalty--;
                if (currPenalty < penalty) {
                    penalty = currPenalty;
                    hour = i + 1;
                }
            } else {
                currPenalty++;
            }
        }
        return hour;
    }
}