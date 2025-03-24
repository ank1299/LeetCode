class Solution {
    public int countDays(int days, int[][] meetings) {
        int daysAvailable = 0;
        //Sort the 2D array
        Arrays.sort(meetings, (a1, a2) -> a1[0] - a2[0]);
        // System.out.println(Arrays.deepToString(meetings));
        int start = 0;
        //To ahndle days before first meeting
        int last = 0;
        
        for(int i = 0;i<meetings.length;i++){
            start = meetings[i][0];
            //To handle days between last max meeting day and current satrt of meeting day
            if(start - last > 1) daysAvailable = daysAvailable + start - last -1;

            // To find new max last meeting day
            last = Integer.max(last,meetings[i][1]);
        }
        //To handle if days are lefta fetr last meeting
        daysAvailable = daysAvailable + days  - last;

        return daysAvailable;
    }
}
