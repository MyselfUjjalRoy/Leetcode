/*
Solution - code story with Mik
see the solution 
extra part to know - fermat's theorem to find the modulo of (a/b)
                   - how to find exponentiation
*/

class Fancy {
    long add;
    long mul;
    ArrayList<Long> list;
    long Mod = 1_000_000_007;

    public Fancy() {
        add = 0;
        mul = 1;
        list = new ArrayList<>();
    }
    long power(long a , long b){
        if(b == 0) return 1;

        long half = power(a , b/2);
        long result = (half * half) % Mod;

        if(b % 2 == 1){
            result = (result * a) % Mod;
        }

        return result;
    }
    
    public void append(int val) {
        list.add(((val - add) % Mod + Mod) * power(mul , Mod - 2) % Mod);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % Mod;
    }
    
    public void multAll(int m) {
        add = (add * m) % Mod;
        mul = (mul * m) % Mod;
    }
    
    public int getIndex(int idx) {
        if(idx >= list.size()) return -1;
        return (int)((list.get(idx) * mul + add) % Mod);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */