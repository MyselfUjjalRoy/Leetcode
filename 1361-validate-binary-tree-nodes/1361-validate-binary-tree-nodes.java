class Solution {
    int[] parent;
    int components;
    
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public boolean union(int par , int child){
        int childParent = find(child);
        if(parent[child] != child){
            return false;
        }

        int parentParent = find(par);
        if(parentParent == childParent){ // means tree hi nahi haiii
        // e.g :- n = 2 , leftChild = {1 , 0} , rightChild = {-1 , - 1}
            return false;
        }

        parent[child] = par;
        components--;

        return true; // union successful
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        components = n;

        for(int i = 0; i < n; i++){
            if(leftChild[i] != -1  && !union(i , leftChild[i])){
                return false;
            }
            if(rightChild[i] != -1 && !union(i , rightChild[i])){
                return false;
            }
        }
        
        return components == 1;
    }
}