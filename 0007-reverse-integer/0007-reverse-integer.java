class Solution {
    public int reverse(int x) {
        int rev = 0;

        while(x != 0){
            int digit = x % 10;
            x = x / 10;
            /*
            If we have a partial result ans and want to add another digit y, the new value would be   ans * 10 + y. This needs to stay within [-2^31, 2^31 - 1].

        For positive numbers, we need: ans * 10 + y ≤ 2^31 - 1

        Rearranging: ans ≤ (2^31 - 1 - y) / 10

        Since y is at most 9, we can simplify our check to: ans ≤ (2^31 - 1) / 10

        Similarly for negative numbers: ans ≥ -2^31 / 10

            */
            if(rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10){
                return 0;
            }

            rev = rev * 10 + digit;
        }

        return rev;
    }
}