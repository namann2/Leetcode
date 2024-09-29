class Solution {
    public int findMinDifference(List<String> timePoints) {
        // minTime, ...time1, time2, .....timeN, .....maxTime
        // The times need to be sorted and we need to cater to 
        // maxTime - minTime in two angles (x and 360-x)
        boolean[] times = new boolean[1440];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(String time : timePoints) {
            String[] split = time.split(":");
            int hr = Integer.valueOf(split[0]);
            int minute = Integer.valueOf(split[1]);
            if(times[hr * 60 + minute]) return 0;
            times[hr * 60 + minute] = true;
            min = Math.min(min, hr * 60 + minute);
            max = Math.max(max, hr * 60 + minute);
        }
        
        int minDiff = Integer.MAX_VALUE;
        int prevMinute = 0;
        // 24 * 60 = 24 * 50 + 24 * 10 = 1200 + 240 = 1440
        for(int minute = 0; minute < 1440; minute++) {
            if(times[minute]) {
                if(minute == min) {
                    minDiff = Math.min(max - min, 1440 - (max - min));
                } else {
                    minDiff = Math.min(minDiff, minute - prevMinute);
                }
                prevMinute = minute;
            }
        }
        return minDiff;
    }
}