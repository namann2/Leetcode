class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        // sort the arrays to arrange buses and passangers as per their earliest times ( departure for bus and arrival for passangers)
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        // Note : we want to reach at max time at which we can board the bus
        Set<Integer> arrivalTimes = new HashSet<>();
        int busesLength = buses.length;
        int passengerLength = passengers.length;
        int prev = 0, currCapacity = 0;
        for(int i = 0; i < busesLength; i++) {
            int runner = prev;
            currCapacity = capacity;
            while(runner < passengerLength && passengers[runner] <= buses[i] && currCapacity > 0) {
                arrivalTimes.add(passengers[runner]);
                currCapacity--;
                runner++;
            }
            prev = runner;
        }
        // AIM : find the latest time for us to board the bus
        // if the capacity of last bus is filled then, we need to come before the time at which the last person arrived
        --prev; // last passanger to board the bus
        if(prev >= 0 && (currCapacity == 0 || buses[busesLength - 1] == passengers[prev])) {
            // we need to reach before this person
            int lastArrivalTime = passengers[prev];
            while(!arrivalTimes.add(lastArrivalTime)) --lastArrivalTime;
            return lastArrivalTime;
        }
        // or else, there is still capacity left for us to board
        return buses[busesLength-1];
    }
}