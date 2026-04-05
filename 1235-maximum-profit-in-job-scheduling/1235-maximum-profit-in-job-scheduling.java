class Solution {
    int[] t;
    public int getNextIdx(int[][] arr ,int l , int currJobEnd){
        int r = arr.length - 1;

        int idx = Integer.MAX_VALUE;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(arr[mid][0] >= currJobEnd){
                idx = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return idx;
    }
    public int solve(int[][] arr , int idx){
        int n = arr.length;

        if(idx >= n){
            return 0;
        }

        if(t[idx] != -1){
            return t[idx];
        }
        
        int nextIdx = getNextIdx(arr , idx + 1 , arr[idx][1]);

        int take = arr[idx][2] + solve(arr , nextIdx);
        int skip = solve(arr , idx + 1);

        return t[idx] = Math.max(take , skip);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        t = new int[n];

        Arrays.fill(t , -1);

        int[][] arr = new int[n][3]; // {start , end , profit}

        for(int i = 0; i < n; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr , (a , b) -> Integer.compare(a[0] , b[0]));

        return solve(arr , 0);
    }
}