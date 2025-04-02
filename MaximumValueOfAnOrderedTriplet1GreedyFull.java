class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        
        long maxValue = nums[0];
        long differenceMax = (long) (nums[0] - nums[1]);
        for(int k = 2;k<nums.length;k++){
            ans = Math.max(ans,(long)differenceMax*nums[k]);
            maxValue = Math.max(maxValue,nums[k-1]);
            //We cannot use min value as index of it (j) must be greater than i
            differenceMax = Math.max(differenceMax,maxValue - nums[k]);
        }
        return ans;
    }
}
