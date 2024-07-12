class JugState {
    public int jug1, jug2;
    public JugState(){}

    public JugState(int jug1, int jug2) {
        this.jug1 = jug1;
        this.jug2 = jug2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.jug1, this.jug2);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        JugState j = (JugState)o;
        return j.jug1 == this.jug1 && j.jug2 == this.jug2;
    }
}

class Solution {

    private int gcd(int a, int b) {
        // base case
        if(a == 0) return b;
        // main logic
        return gcd(b % a, a);
    }
    public boolean canMeasureWater(int CA, int CB, int k) {
        // edge cases
        if(k == CA + CB) 
            return true;
        
        if(k > CA + CB)
            return false;

        // // if it is possible to get to the target using given conditions
        // if(k % gcd(CA, CB) != 0)
        //     return false;
        // return true

        Set<JugState> visited = new HashSet<>();
        JugState startState = new JugState(0, 0);

        visited.add(startState);

        Queue<JugState> q = new LinkedList<>();
        q.offer(startState);
        // temp state

        while(!q.isEmpty()) { // TODO : verify the iteration logic
            
            JugState curr = q.poll();

            // early break
            if(curr.jug1 + curr.jug2 == k || curr.jug1 == k || curr.jug2 == k)
                return true;

            // pour from CB -> CA
            JugState pourBToA = new JugState();
            int canPour = Math.min(curr.jug2, CA - curr.jug1);
            pourBToA.jug1 = curr.jug1 + canPour; // CA
            pourBToA.jug2 = curr.jug2 - canPour;

            if(visited.add(pourBToA)) {
                q.offer(pourBToA);
            }

            // pour from CA -> CB
            JugState pourAToB = new JugState();
            canPour = Math.min(curr.jug1, CB - curr.jug2);
            pourAToB.jug1 = curr.jug1 - canPour;
            pourAToB.jug2 = curr.jug2 + canPour; // CB

            if(visited.add(pourAToB)) {
                q.offer(pourAToB);
            }

            // empty CA
            JugState emptyA = new JugState();
            emptyA.jug1 = 0;
            emptyA.jug2 = curr.jug2;
            
            if(visited.add(emptyA)) {
                q.offer(emptyA);
            }

            // empty CB
            JugState emptyB = new JugState();
            emptyB.jug2 = 0;
            emptyB.jug1 = curr.jug1;

            if(visited.add(emptyB)) {
                q.offer(emptyB);
            }

            // fill CA completely
            JugState fillA = new JugState();
            fillA.jug1 = CA;
            fillA.jug2 = curr.jug2;

            if(visited.add(fillA)) {
                q.offer(fillA);
            }

            // fill CB completely
            JugState fillB = new JugState();
            fillB.jug1 = curr.jug1;
            fillB.jug2 = CB;

            if(visited.add(fillB)) {
                q.offer(fillB);
            }
        }

        return false;
    }
}