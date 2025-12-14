class Solution {
    static int mod = 1_000_000_007;
    public int numberOfWays(String corridor) {
        ArrayList<Integer> seatPos = new ArrayList<>();
        for(int i =0; i < corridor.length(); i++){
            if(corridor.charAt(i) == 'S'){
                seatPos.add(i);
            }
        }
        if(seatPos.size() == 0 || seatPos.size() % 2 ==1){
            return 0;
        }
        long ans = 1;
        int prevPos = seatPos.get(1);
        for(int i = 2; i < seatPos.size(); i+= 2){
            int currPos = seatPos.get(i);
            int length = currPos - prevPos;
            ans = (ans * length) % mod;
            prevPos = seatPos.get(i + 1);
        }
        return (int)ans;
    }
}