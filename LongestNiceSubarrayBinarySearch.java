class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        //binary search on index not length hence not -1
        int right = nums.length;
        int ans = 1;

        while(left <= right){
            int length = left + (right-left)/2;
            if(canFormNiceSubArray(length,nums)){
                ans = length;
                left = length +1;
            }else{
                right = length -1;
            }
        }
        return ans;
    }

    boolean canFormNiceSubArray(int length,int[] nums){
        if(length <= 1) return true;
        
        for(int i = 0;i<=nums.length - length;i++){
            int bitOr = 0;
            boolean isNice = true;
            for(int j = i;j< i + length;j++){
                if((bitOr & nums[j]) != 0){
                    isNice = false;
                    break;
                }
                bitOr = bitOr | nums[j];
            }
            if(isNice == true)return true;
        }
        return false;
    }
}
