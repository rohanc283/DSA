class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfiedCustomers = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0)
                satisfiedCustomers += customers[i];
        }

        int maximumSatisfiedCustomers = satisfiedCustomers;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (grumpy[j] == 1) {
                satisfiedCustomers += customers[j];
            }

            if (j >= minutes - 1) {
                maximumSatisfiedCustomers = Math.max(maximumSatisfiedCustomers, satisfiedCustomers);
                if (grumpy[i] == 1) {
                    satisfiedCustomers -= customers[i];
                }
                i++;
            }
        }
        return maximumSatisfiedCustomers;
    }
}