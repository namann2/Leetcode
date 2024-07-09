Not Sure About the Complexity Analysis : 


Option 1 : 
Time complexity is O(9216) reduced to O(1)
There are 4 numbers to choose from: 4
After choosing the 1st number, there are 3 numbers to choose from: 3
after picking a pair of numbers, you have 4 operations to choose from: 4
Then you have 3 numbers to choose from: 3
Then you have 2 numbers to choose from: 2

after picking a pair of numbers, you have 4 operations to choose from: 4
Then you have 2 numbers to choose from: 2
Then you have 1 number1 to choose from: 1
after picking a pair of numbers, you have 4 operations to choose from: 4
4x3x4x3x2x4x2x1x4 = O(9216) = O(1)

Option 2 :

<img width="358" alt="Screenshot 2024-07-09 at 4 33 44 PM" src="https://github.com/namann2/Leetcode/assets/59756482/744cb8cd-cfb3-44ba-808e-b89482829d77">


Imporant Comparision : 

In order to compare two double values, we need to use " threshold comparision method"
- https://www.baeldung.com/java-comparing-doubles
- https://stackoverflow.com/questions/8081827/how-to-compare-two-double-values-in-java
    
```

class Solution {
    private static final double eps = 0.000001;
    
    public boolean judgePoint24(int[] cards) {
        ArrayList<Double> list = new ArrayList<>();
        for(int card : cards) 
            list.add((double)card);
        
        return exploreUtil(list);
    }
    private boolean exploreUtil(ArrayList<Double> list) {
        // base check
        if(list.size() == 1) {
            return Math.abs(list.get(0) - 24.0) < eps;
        }
        
        // main logic
        // pick any two numbrs from the list and traverse all the possible options
        int n = list.size();
        for(int i=0;i<n;i++) {
            double first = list.get(i);
            for(int j=i+1;j<n;j++) {
                double second = list.get(j);
                ArrayList<Double> nextIteration = new ArrayList<>();
                for(int k=0;k<n;k++) 
                    if(k!=i && k!=j)
                        nextIteration.add(list.get(k));
                
                // add all possible options we have for thee picked two numbers
                for(double number : computeOptions(first, second)) {
                    nextIteration.add(number);
                    if(exploreUtil(nextIteration))
                        return true;
                    nextIteration.remove(nextIteration.size()-1);
                }
            }
        }
        return false;
    }

    private List<Double> computeOptions(double a, double b) {
        List<Double> l = new ArrayList<>();
        l.add(a+b);
        
        l.add(a-b);
        l.add(b-a);
        
        if(b != 0) l.add(a/b);
        if(a != 0) l.add(b/a);
        
        l.add(a*b);
        
        return l;
    }
}

```
