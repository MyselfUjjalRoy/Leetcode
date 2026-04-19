//Approach (Using Segment Tree Range Maximum Query + Binary Search)
//T.C : O(n + q*(logn)^2) -> tree build - O(n) and binary search * query - log n * log n
//S.C : O(n)

// but the time complexity can be improved using monotonic queue -> T.C : O(n + q*(logn))
class Solution {
    public void buildSegmentTree(int i , int l , int r , int[] segmentTree , int[] heights){
        if(l == r){
            segmentTree[i] = l; // store the index
            return;
        }

        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1 , l , mid , segmentTree , heights);
        buildSegmentTree(2 * i + 2 , mid + 1 , r , segmentTree , heights);

        // store the index of the maximum element
        segmentTree[i] = (heights[segmentTree[2 * i + 1]] >= heights[segmentTree[2 * i + 2]] ? segmentTree[2 * i + 1] : segmentTree[2 * i + 2]);
    }

    public int querySegmentTree(int start , int end , int i , int l , int r , int[] segmentTree , int[] heights){
        if(l > end || r < start){
            return -1; // return -1 for out of bound queries
        }

        if(l >= start && r <= end){
            return segmentTree[i]; // return the index of the maximum element
        }

        int mid = l + (r - l) / 2;
        int leftIdx = querySegmentTree(start , end , 2 * i + 1 , l , mid , segmentTree , heights);
        int rightIdx = querySegmentTree(start , end , 2 * i + 2 , mid + 1 , r ,  segmentTree , heights);

        if(leftIdx == -1) return rightIdx;
        if(rightIdx == -1) return leftIdx;

        return (heights[leftIdx] >= heights[rightIdx] ? leftIdx : rightIdx);
    }

    public int RMIQ(int[] segmentTree , int[] heights , int a , int b){
        return querySegmentTree(a , b , 0 , 0 , heights.length - 1 , segmentTree , heights);
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] segmentTree = new int[4 * n];
        buildSegmentTree(0 , 0 , n - 1 , segmentTree , heights);
        
        int[] result = new int[queries.length];

        for(int q = 0; q < queries.length; q++){
            int alice = Math.min(queries[q][0] , queries[q][1]);
            int bob = Math.max(queries[q][0] , queries[q][1]);

            if(alice == bob || heights[bob] > heights[alice]){
                result[q] = bob;
                continue;
            }
            
            int l = bob + 1 , r = n - 1 , resultIdx = Integer.MAX_VALUE;

            while(l <= r){
                int mid = l + (r - l) / 2;
                //RMIQ -> Range Maximum Index query
                int idx = RMIQ(segmentTree , heights , l , mid);

                if(heights[idx] > Math.max(heights[alice] , heights[bob])){
                    resultIdx = Math.min(resultIdx , idx);
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }

            result[q] = (resultIdx == Integer.MAX_VALUE ? -1 : resultIdx);
        }
        return result;
    }
}