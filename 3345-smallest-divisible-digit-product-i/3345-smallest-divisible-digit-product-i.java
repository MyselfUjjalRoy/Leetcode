class Solution {
    public int smallestNumber(int n, int t) {
        while (n < 100) {
            if (n < 10) {
                if (n % t == 0) {
                    return n;
                }
            } else {
                int rem1 = n % 10;
                int rem2 = n / 10;
                if ((rem1 * rem2) % t == 0) {
                    return n;
                } 
            }
            n++;

        }
        return 100;
    }
}