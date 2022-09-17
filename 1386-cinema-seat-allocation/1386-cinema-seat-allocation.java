class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> occupied = new HashMap<>();
        for(int[] seat : reservedSeats) {
            int row = seat[0], loc = seat[1];
            occupied.putIfAbsent(row, new HashSet<>());
            occupied.get(row).add(loc);
        }
        
        int groups = 2 * (n - occupied.size());
            
        for(int row : occupied.keySet()) {
            // is configuration filled
            boolean isA = false, isB = false, isC = false;
            Set<Integer> occupiedSeatsInRow = occupied.get(row);
            
            if(occupiedSeatsInRow.contains(2) || 
               occupiedSeatsInRow.contains(3) || 
               occupiedSeatsInRow.contains(4) || 
               occupiedSeatsInRow.contains(5)) {
                isA = false;
            } else isA = true;
            
            
            if(occupiedSeatsInRow.contains(6) || 
                   occupiedSeatsInRow.contains(7) || 
                   occupiedSeatsInRow.contains(8) || 
                   occupiedSeatsInRow.contains(9)) {
                isC = false;
            } else isC = true;
            
            if(!isC && !isA) {
                if(occupiedSeatsInRow.contains(4) || 
                   occupiedSeatsInRow.contains(5) || 
                   occupiedSeatsInRow.contains(6) || 
                   occupiedSeatsInRow.contains(7)) {
                    isB = false;
                } else isB = true;
            }
            
            groups += isA == true ? 1 : 0;
            groups += isB == true ? 1 : 0;
            groups += isC == true ? 1 : 0;
        }
        return groups;
    }
}