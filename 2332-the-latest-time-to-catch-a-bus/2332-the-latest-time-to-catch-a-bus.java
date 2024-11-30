class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        Set<Integer> arrivalTimes = new HashSet<>();
        for(int arrivalTime : passengers) arrivalTimes.add(arrivalTime);
        
        int busesLength = buses.length, passangerLength = passengers.length;
        int prev = 0, currCapacity = 0;
        for(int i = 0; i < busesLength; i++) {
            int runner = prev;
            currCapacity = capacity;
            // check which passengers gets on the bus
            while(runner < passangerLength && passengers[runner] <= buses[i] && currCapacity > 0) {
                currCapacity--; // this passanger onboarded the bus[i]
                runner++;
            }
            prev = runner;
        }
        --prev;
        if(prev >= 0 && (currCapacity == 0 || passengers[prev] == buses[busesLength-1])) {
            int runner = prev, time = passengers[prev];
            while(runner >= 0 && arrivalTimes.contains(time)) {
                runner--;
                time--;
            }
            return time;
        }
        return buses[busesLength-1];
    }
}