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

        char[] c = s.toCharArray();
        int n = c.length;

        int res = 0;

        //Case-1
        int cur = 1;

        for (int i = 1; i < n; i++) {
            if (c[i] == c[i - 1]) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 1;
            }
        }
        res = Math.max(res, cur);

        //Case-2
        res = Math.max(res, find2(s, 'a', 'b'));
        res = Math.max(res, find2(s, 'a', 'c'));
        res = Math.max(res, find2(s, 'b', 'c'));

        
        //Case-3
        int ca = 0, cb = 0, cc = 0;

        Map<Pair, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (c[i] == 'a') ca++;
            else if (c[i] == 'b') cb++;
            else cc++;

            if(ca == cb && ca == cc)
                res = Math.max(res, ca+cb+cc);

            Pair key = new Pair(ca - cb, ca - cc);

            Integer prev = mp.get(key);
            if (prev != null) {
                res = Math.max(res, i - prev);
            } else {
                mp.put(key, i);
            }
        }

        return res;
    }

    private int find2(String s, char x, char y) {
    int maxLen = 0;
    int countX = 0;
    int countY = 0;

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if (ch != x && ch != y) {
            // reset if not x or y
            countX = 0;
            countY = 0;
            continue;
        }

        if (ch == x) countX++;
        if (ch == y) countY++;

        if (countX == countY) {
            maxLen = Math.max(maxLen, countX + countY);
        }
    }

    return maxLen;
}

}