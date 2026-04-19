class NumArray {
    int n;
    int[] segmentTree;

    public void buildSegmentTree(int i , int l , int r , int[] nums){
        if(l == r){
            segmentTree[i] = nums[l];
            return;
        }

        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1 , l , mid , nums);
        buildSegmentTree(2 * i + 2 , mid + 1 , r , nums);

        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];

        buildSegmentTree(0 , 0 , n - 1 , nums);
    }

    public void updateSegmentTree(int index , int val , int i , int l , int r){
        if(l == r){
            segmentTree[i] = val;
            return;
        }

        int mid = l + (r - l) / 2;
        if(index <= mid){
            updateSegmentTree(index , val , 2 * i + 1 , l , mid);
        }
        else{
            updateSegmentTree(index , val , 2 * i + 2 , mid + 1 , r);
        }

        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }
    
    public void update(int index, int val) {
        updateSegmentTree(index , val , 0 , 0 , n - 1);
    }

    public int querySegmentTree(int left , int right , int i , int l , int r){
        if(l > right || r < left){
            return 0;
        }

        if(l >= left && r <= right){
            return segmentTree[i];
        }

        int mid = l + (r - l) / 2;
        return querySegmentTree(left , right , 2 * i + 1 , l , mid) + 
        querySegmentTree(left , right , 2 * i + 2 , mid + 1 , r);
    }
    
    public int sumRange(int left, int right) {
        return querySegmentTree(left , right , 0 , 0 , n - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */