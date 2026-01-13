class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double high = -Double.MAX_VALUE;
        double low = Double.MAX_VALUE;
        for(int[] square : squares){
            int y = square[1];
            int l = square[2];
            totalArea += (double)l * l;
            
            high = Math.max(high , y + l);
            low = Math.min(low , y);
        }
        double resultY = 0.0;
        while(high - low > 1e-5){
            double midY = low + (high - low)/2.0;
            resultY = midY;
            if(check(midY , totalArea , squares)){
                high = midY;
            }
            else{
                low = midY;
            }
        }
        return resultY;
    }
    public boolean check(double midY , double totalArea , int[][] squares){
        double bottomArea = 0.0;
        for(int[] square : squares){
            double y = square[1];
            double l = square[2];

            double bottomY = y;
            double topY = y + l;

            if(midY >= topY){
                bottomArea += l * l;
            }
            else if(midY > bottomY){
                bottomArea += (midY - bottomY) * l;
            }
        }
        return bottomArea >= totalArea / 2.0;
    }
}