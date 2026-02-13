import java.util.*;

class Solution {

    static class Pair {
        int d1, d2;

        Pair(int d1, int d2) {
            this.d1 = d1;
            this.d2 = d2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return d1 == p.d1 && d2 == p.d2;
        }

        @Override
        public int hashCode() {
            return 31 * d1 + d2;
        }
    }

    public int longestBalanced(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int res = 0;

        // Case-1: consecutive same characters
        int cur = 1;
        for (int i = 1; i < n; i++) {
            if (c[i] == c[i - 1]) cur++;
            else {
                res = Math.max(res, cur);
                cur = 1;
            }
        }
        res = Math.max(res, cur);

        // Case-2: any two characters balanced
        res = Math.max(res, find2(s, 'a', 'b'));
        res = Math.max(res, find2(s, 'a', 'c'));
        res = Math.max(res, find2(s, 'b', 'c'));

        // Case-3: all three characters balanced
        int ca = 0, cb = 0, cc = 0;
        Map<Pair, Integer> mp = new HashMap<>();
        mp.put(new Pair(0, 0), -1); // base case

        for (int i = 0; i < n; i++) {
            if (c[i] == 'a') ca++;
            else if (c[i] == 'b') cb++;
            else cc++;

            Pair key = new Pair(ca - cb, ca - cc);
            if (mp.containsKey(key)) {
                res = Math.max(res, i - mp.get(key));
            } else {
                mp.put(key, i);
            }
        }

        return res;
    }

    // Optimized find2 using array instead of HashMap
    private int find2(String s, char ch1, char ch2) {
        int n = s.length();
        int[] first = new int[2 * n + 1]; // stores first index of each diff
        Arrays.fill(first, -2);           // -2 = not seen
        int maxLen = 0;

        int count1 = 0, count2 = 0;
        int diff = n;       // offset so diff=0 maps to index n
        first[diff] = -1;   // base case before string starts
        int clearIdx = -1;  // last index of reset (non-ch1/ch2)

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c != ch1 && c != ch2) {
                // reset for invalid character
                count1 = 0;
                count2 = 0;
                diff = n;
                clearIdx = i;
                first[diff] = clearIdx;
                continue;
            }

            if (c == ch1) count1++;
            if (c == ch2) count2++;

            diff = count1 - count2 + n;

            if (first[diff] < clearIdx) {
                first[diff] = i;
            } else {
                maxLen = Math.max(maxLen, i - first[diff]);
            }
        }

        return maxLen;
    }
}
