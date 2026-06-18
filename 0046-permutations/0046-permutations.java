class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        permutations(nums,0,res);
        return res;
    }
    public void permutations(int[] nums,int index,List<List<Integer>> res){
        int n=nums.length;
        //base case
        if(index==n-1){
            List<Integer> sublist=new ArrayList<Integer>();
            for(int num:nums){
                sublist.add(num);
            }
            res.add(new ArrayList<>(sublist));
            return;
        }

        //tasks
        for(int i=index;i<n;i++){
            swap(nums,i,index);
            permutations(nums,index+1,res);
            swap(nums,i,index);
        }
    }
    public void swap(int nums[],int pos1,int pos2){
        int temp=nums[pos1];
        nums[pos1]=nums[pos2];
        nums[pos2]=temp;
    }
}