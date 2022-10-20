/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cel = 0;
        for(int i=1;i<n;i++) {
            if(knows(cel, i) || !knows(i, cel))
                cel = i;
        }
        
        for(int i=0;i<n;i++)
            if(i!=cel && (!knows(i, cel) || knows(cel, i)))
                return -1;
        return cel;
    }
}