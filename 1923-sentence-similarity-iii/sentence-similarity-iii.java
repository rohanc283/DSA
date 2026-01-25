class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] sent1 = sentence1.split(" ");
        String[] sent2 = sentence2.split(" ");
        String[] shorter = sent1.length <= sent2.length ? sent1 : sent2;
        String[] longer = sent2.length >= sent1.length ? sent2 : sent1;
        int i = 0;
        while (i < shorter.length && i < longer.length && shorter[i].equals(longer[i])) {
            i++;
        }
        if (i != 0 && i >= shorter.length)
            return true;
        int j = shorter.length - 1;
        int k = longer.length - 1;
        while (j >= 0 && shorter[j].equals(longer[k])) {
            j--;
            k--;
        }
        if (i == 0 && j == 0)
            return false;
        if (i > j)
            return true;
        return false;
    }
}