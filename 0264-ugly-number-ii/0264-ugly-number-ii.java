//(Bottom Up DP)
//T.C : O(n))
//S.C : O(n)
/*
    We have an array k of first n ugly number. We only know, at the beginning, the first one, which is 1. Then

    k[1] = min( k[0]x2, k[0]x3, k[0]x5). The answer is k[0]x2. So we move 2's pointer to 1. Then we test:

    k[2] = min( k[1]x2, k[0]x3, k[0]x5). And so on. Be careful about the cases such as 6, in which we need to forward both pointers of 2 and 3.
*/
class Solution {
    public int nthUglyNumber(int n) {
        int[] t = new int[n + 1];
        // t[i] -> i th ugly number

        t[1] = 1; // 1st ugly number

        int i2 = 1; // i2 th ugly number 
        int i3 = 1; // i3 rd ugly number
        int i5 = 1; // i4 th ugly number

        for(int i = 2; i <= n; i++){
            int i2_th_ugly = t[i2] * 2;
            int i3_rd_ugly = t[i3] * 3;
            int i5_th_ugly = t[i5] * 5;

            t[i] = Math.min(i2_th_ugly , Math.min(i3_rd_ugly , i5_th_ugly));


            if(t[i] == i2_th_ugly){
                i2++;
            }
            if(t[i] == i3_rd_ugly){
                i3++;
            }
            if(t[i] == i5_th_ugly){
                i5++;
            }
        }

        return t[n];
    }
}