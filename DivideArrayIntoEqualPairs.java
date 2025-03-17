class Solution {
    public boolean divideArray(int[] nums) {
        if(nums.length % 2 !=0 )return false;
        int data[] = new int[501];

        for(int num : nums){
            data[num]++;
        }

        for(int number = 1;number<=500;number++){
            if(data[number] %2 != 0) return false;
        }
        return true;
    }
}
