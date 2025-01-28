class Solution {
    public double myPow(double x, int n) {
        // If n is negative, convert it to a long to avoid overflow
        long longN = n;
        return myPowHelper(x, longN);
    }

    private double myPowHelper(double x, long n) {
        if (n == 0) {
            return 1; // Base case: x^0 = 1
        }
        if (n < 0) {
            return 1.0 / myPowHelper(x, -n); // Handle negative powers
        }
        
        double halfPower = myPowHelper(x, n / 2);
        if (n % 2 == 0) {
            return halfPower * halfPower; // If n is even
        } else {
            return x * halfPower * halfPower; // If n is odd
        }
    }
}
