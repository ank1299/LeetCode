class Solution {
    public long repairCars(int[] ranks, int cars) {
        long start = Long.MAX_VALUE;
        long end = Long.MIN_VALUE;
        long ans = 0;
        for(int rank : ranks){
            start = Math.min(start,rank);
            end = Math.max(end,rank);
        }

        end = end * cars * cars;

        while(start<=end){
            long mid = start + (end-start)/2;
            if(isCarRepaired(ranks,cars,mid)){
                ans = mid;
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        return ans;
    }

    public boolean isCarRepaired(int [] ranks , int cars, long time){
        long carsRepaired = 0;
        for(int rank : ranks){
            carsRepaired = carsRepaired +  (long)Math.sqrt((1.0 * time)/rank);
            if(carsRepaired >= cars){return true;}
        }
        return false;
    }
}
