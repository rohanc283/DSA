class Solution {
    public int bestClosingTime(String customers) {
        int totalPenalty = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y')
                totalPenalty++;
        }
        int minPenalty = totalPenalty;
        int minPenaltyHour = 0;
        int customersVisited = 0, customersNotVisited = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y')
                customersVisited++;
            else {
                customersNotVisited++;
            }
            int currPenalty = totalPenalty - customersVisited + customersNotVisited;
            if (currPenalty < minPenalty) {
                minPenalty = currPenalty;
                minPenaltyHour = i + 1;
            }
        }
        return minPenaltyHour;
    }
}