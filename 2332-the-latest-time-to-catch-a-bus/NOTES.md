The below code can be optimised to reduce redundancy in the way it was submitted but I'd rather choose not to while practice.

```
class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        // sort the arrays to arrange buses and passangers as per their earliest times ( departure for bus and arrival for passangers)
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        // Note : we want to reach at max time at which we can board the bus, which is viable if we onboard to the last bus that leaves
        
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
        // case 1 : if the capacity of last bus is filled then, we need to come before the time at which the last person arrived
        --prev; // last passanger to board the bus
        if(prev >= 0 && currCapacity == 0) { // currCapacity = 0 means the last bus is completely filled
            // we need to reach before the last person
            int lastArrivalTime = passengers[prev];
            while(!arrivalTimes.add(lastArrivalTime)) --lastArrivalTime;
            return lastArrivalTime;
        }
        // case 2a : or else, there is still capacity left for us to board
        // if the last person arrived just in time the last bus was leaving, we need to arrive before this person
        if(prev >= 0 && buses[busesLength - 1] == passengers[prev]) {
            int lastArrivalTime = passengers[prev];
            while(!arrivalTimes.add(lastArrivalTime)) --lastArrivalTime;
            return lastArrivalTime;
        }
        // case 2b : if the last person did not come at the max time the bus could leave at, then we can choose to arrive just in time
        return buses[busesLength-1];
    }
}
```
