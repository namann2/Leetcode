class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // line sweep algorithm
        // adding 0 since, for an arrival in say, January no days of months will be required
        int[]a = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[]ps = new int[13];
        
        for(int i=1;i<13;i++)
            ps[i] += a[i] + ps[i-1];
        
        int[]line = new int[400];
        
        int alice_arrival_month = Integer.valueOf(arriveAlice.split("-")[0]);
        int alice_arrival_days = Integer.valueOf(arriveAlice.split("-")[1]);
        int alice_a = ps[alice_arrival_month-1] +  alice_arrival_days;
        
        int alice_depart_month = Integer.valueOf(leaveAlice.split("-")[0]);
        int alice_depart_days = Integer.valueOf(leaveAlice.split("-")[1]);
        int alice_d = ps[alice_depart_month-1] + alice_depart_days;
        
        int bob_arrival_month = Integer.valueOf(arriveBob.split("-")[0]);
        int bob_arrival_days = Integer.valueOf(arriveBob.split("-")[1]);
        int bob_a = ps[bob_arrival_month-1] + bob_arrival_days;
        
        int bob_depart_month = Integer.valueOf(leaveBob.split("-")[0]);
        int bob_depart_days = Integer.valueOf(leaveBob.split("-")[1]);
        int bob_d = ps[bob_depart_month-1] + bob_depart_days;
        
        line[alice_a]+=1;
        line[alice_d+1]-=1;
        line[bob_a]+=1;
        line[bob_d+1]-=1;
        
        int cnt = line[0] == 2 ? 1 : 0;
        
        for(int i=1;i<400;i++)
        {
            line[i] += line[i-1];
            if(line[i] == 2) ++cnt;
        }
        
        return cnt;
    }
}