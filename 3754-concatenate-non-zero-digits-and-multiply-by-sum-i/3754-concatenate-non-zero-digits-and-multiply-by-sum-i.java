class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        StringBuilder sb = new StringBuilder();

        while(n != 0){
            int rem = n % 10;
            if(rem != 0){
                sum += rem;
                sb.append(rem);
            }
            
            n /= 10;
        }

        long value = sb.length() == 0 ? 0 : Long.parseLong(sb.reverse().toString());
        //int num = String.valueOf(value);

        return value * sum;
    }
}