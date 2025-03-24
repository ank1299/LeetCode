class Solution {
    public int countDays(int days, int[][] meetings) {
        int daysAvailable = days;
        boolean daysArray[] = new boolean [days + 1];

        for(int i=0;i<meetings.length;i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            while(start<=end){
                //not yet meeting scheduled for the day
                if(daysArray[start] == false){
                    daysArray[start] = true;
                    daysAvailable--;
                }
                start++;
            }
        }
        return daysAvailable;
    }
}
