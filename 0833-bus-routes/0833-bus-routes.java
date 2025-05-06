class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        // create a map that stores the buses one can board from given stop
        Map<Integer, List<Integer>> canTakeBusFromStop = new HashMap<>();
        int n = routes.length;
        boolean isSourcePresent = false, isTargetPresent = false;
        for(int bus = 0; bus < n; bus++) {
            for(int stop : routes[bus]) {
                if(stop == source) isSourcePresent = true;
                if(stop == target) isTargetPresent = true;
                canTakeBusFromStop.putIfAbsent(stop, new ArrayList<>());
                canTakeBusFromStop.get(stop).add(bus);
            }
        }

        if(!(isSourcePresent && isTargetPresent)) return -1;

        Queue<int[]> stops = new LinkedList<>();
        stops.offer(new int[]{source, 0}); // current stop, number of buses taken to reach current stop

        // one stop can be visited by boarding multiple buses, we do not want to visit the stops again
        Set<Integer> stopsVisited = new HashSet<>();
        // one bus will travel through multiple stops, since we are considering buses we can board from
        // a given stop, we need to have a visited bus set to not board the same bus again
        Set<Integer> busVisited = new HashSet<>();

        stopsVisited.add(source);

        while(!stops.isEmpty()) {
            int[] current = stops.remove();
            int stop = current[0], busesTaken = current[1];
            // early break condition
            if(stop == target) return busesTaken;
            // what all buses we can board from a given stop
            for(int bus : canTakeBusFromStop.get(stop)) {
                // if a bus is already boarded, move to next bus
                if(!busVisited.add(bus)) continue;
                // a bus, will move to different stops, add them to the queue for next visit
                for(int nextStop : routes[bus]) {
                    // only if the next stop is not already visited
                    if(stopsVisited.add(nextStop)) {
                        stops.offer(new int[]{nextStop, busesTaken + 1});
                    }
                }
            }
        }
        return -1;
    }
}