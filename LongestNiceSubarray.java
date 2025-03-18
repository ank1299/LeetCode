class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0;
        int bitsOr = 0;
        int ans = 1;
        for(int i=0;i<nums.length;i++){
            int current = nums[i];
            while((bitsOr & current) != 0){
                int firstEle = nums[start];
                //removing first element of window from left
                // it works as no other element would have set those particular bits in bitOr
                bitsOr = bitsOr ^ firstEle;
                start++;
            }
            //increasing window side in right
            bitsOr = bitsOr | current;
            ans = Math.max(ans, i-start +1);
        }
        return ans;
    }
}
