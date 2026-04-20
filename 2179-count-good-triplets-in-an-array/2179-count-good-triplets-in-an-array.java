class Solution {

    public void updateSegmentTree(int i , int l , int r , int updateIdx , long[] segmentTree){
        if(l == r){
            segmentTree[i] = 1;
            return;
        }
        int mid = l + (r - l) / 2;
        if(updateIdx <= mid){
            updateSegmentTree(2 * i + 1 , l , mid , updateIdx , segmentTree);
        }
        else{
            updateSegmentTree(2 * i + 2 , mid + 1 , r , updateIdx , segmentTree);
        }

        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    public long querySegmentTree(int queryStart , int queryEnd , int i , int l , int r , long[] segmentTree){
        if(r < queryStart || l > queryEnd){
            return 0;
        }

        if(l >= queryStart && r <= queryEnd){
            return segmentTree[i];
        }

        int mid = l + (r - l) / 2;
        long left = querySegmentTree(queryStart , queryEnd , 2 * i + 1 , l , mid , segmentTree);
        long right = querySegmentTree(queryStart , queryEnd , 2 * i + 2 , mid + 1 , r , segmentTree);

        return left + right;

    }
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums2[i] , i);
        }

        long[] segmentTree = new long[4  * n];

        long result = 0;

        updateSegmentTree(0 , 0 , n - 1 , map.get(nums1[0]) , segmentTree);

        for(int i = 1; i < n; i++){
            int idx = map.get(nums1[i]);
            long leftCommonCount = querySegmentTree(0 , idx , 0 , 0 , n - 1, segmentTree);
            long leftNotCommonCount = i - leftCommonCount;
            long elementsAfterIdxNums2 = (n - 1) - idx;
            long rightCommonCount = elementsAfterIdxNums2 - leftNotCommonCount;
            result += leftCommonCount * rightCommonCount;

            updateSegmentTree(0 , 0 , n - 1 , idx , segmentTree);
        }

        return result;
    }
}