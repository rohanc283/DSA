class Solution {
    public int bestClosingTime(String customers) {
        int totalY = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y')
                totalY++;
        }

        int minPenalty = totalY;
        int currPenalty = totalY;
        int bestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                currPenalty--;
            } else {
                currPenalty++;
            }

            if (currPenalty < minPenalty) {
                minPenalty = currPenalty;
                bestHour = i + 1;
            }
        }
        return bestHour;
    }
}
