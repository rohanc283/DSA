class Solution {
    Map<Integer, String> twentysMap = new HashMap<>() {
        {
            put(0, "Zero");
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
            put(4, "Four");
            put(5, "Five");
            put(6, "Six");
            put(7, "Seven");
            put(8, "Eight");
            put(9, "Nine");
            put(10, "Ten");
            put(11, "Eleven");
            put(12, "Twelve");
            put(13, "Thirteen");
            put(14, "Fourteen");
            put(15, "Fifteen");
            put(16, "Sixteen");
            put(17, "Seventeen");
            put(18, "Eighteen");
            put(19, "Nineteen");
        }
    };

    Map<Integer, String> hundredsMap = new HashMap<>() {
        {
            put(20, "Twenty");
            put(30, "Thirty");
            put(40, "Forty");
            put(50, "Fifty");
            put(60, "Sixty");
            put(70, "Seventy");
            put(80, "Eighty");
            put(90, "Ninety");
        }
    };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        if (twentysMap.containsKey(num))
            return twentysMap.get(num);

        if (hundredsMap.containsKey(num))
            return hundredsMap.get(num);

        if (num < 100) {
            return numberToWords(num - (num % 10)) + " " + numberToWords(num % 10);
        } else if (num < 1000) {
            if (num % 100 == 0)
                return numberToWords(num / 100) + " Hundred";
            return numberToWords(num / 100) + " Hundred " + numberToWords(num % 100);
        } else if (num < 1_000_000) {
            if (num % 1000 == 0)
                return numberToWords(num / 1000) + " Thousand";
            return numberToWords(num / 1000) + " Thousand " + numberToWords(num % 1000);
        } else if (num < 1_000_000_000) {
            if (num % 1_000_000 == 0)
                return numberToWords(num / 1_000_000) + " Million";
            return numberToWords(num / 1_000_000) + " Million " + numberToWords(num % 1_000_000);
        } else {
            if (num % 1_000_000_000 == 0)
                return numberToWords(num / 1_000_000_000) + " Billion";
            return numberToWords(num / 1_000_000_000) + " Billion " + numberToWords(num % 1_000_000_000);
        }
    }
}