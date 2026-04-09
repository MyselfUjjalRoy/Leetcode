class NumArray {
    int blockSize;
    int[] nums;
    int[] blockSum;

    public NumArray(int[] arr) {
        nums = arr.clone();
        int n = nums.length;
        blockSize = (int)Math.ceil(Math.sqrt(n));

        blockSum = new int[blockSize];
        
        for(int i = 0; i < n; i++){
            blockSum[i / blockSize] += nums[i]; 
        }
    }
    
    public void update(int index, int val) {
        int blockIdx = index / blockSize;
        blockSum[blockIdx] -= nums[index];
        blockSum[blockIdx] += val;
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int startBlockIndex = left / blockSize;
        int endBlockIndex = right / blockSize;

        // case - 1
        int sum = 0;
        if(startBlockIndex == endBlockIndex){
            for(int i = left; i <= right; i++){
                sum += nums[i];
            }
            return sum;
        }
        
        // case - 2 
        int sum2 = 0;
        int endOfStartBlock = ((startBlockIndex + 1) * blockSize) - 1;

        // left Partial sum
        for(int i = left; i <= endOfStartBlock; i++){
            sum2 += nums[i];
        }

        // middle full block sum
        for(int b = startBlockIndex + 1; b <= endBlockIndex - 1; b++){
            sum2 += blockSum[b];
        }

        // right partial sum
        int startOfEndBlock = endBlockIndex * blockSize;
        for(int i = startOfEndBlock; i <= right; i++){
            sum2 += nums[i];
        }

        return sum2;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */