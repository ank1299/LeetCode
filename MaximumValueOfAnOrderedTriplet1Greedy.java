class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        
        
        for(int k = 2;k<nums.length;k++){
            int maxValue = nums[0];
            for(int j=1;j<k;j++){
                ans = Math.max(ans,(long)(maxValue - nums[j])*nums[k]);
                maxValue = Math.max(maxValue,nums[j]);
            }
        }
        return ans;
    }
}
