class Solution {
    // Total TC : O(n logm logn) also, m at max could fit in a 32 bit integer, hence could be taken as constant
    public int minimumDeviation(int[] A) {
        // add, remove, and contains -> O(Logn)
        TreeSet<Integer> numbers = new TreeSet<>();
        // reducing the number of instructions to be used from two to one
        for(int num : A) { // O(nlogn)
            if((num&1) == 1) numbers.add(2*num);
            else numbers.add(num);
        }
        // maximum number could be the power of 2 which will take logn operations to reduce to an odd number
        int minDeviation = numbers.last() - numbers.first();
        while(!numbers.isEmpty() && !isOdd(numbers.last())) { // n logm logn
            int min = numbers.first(); // O(1)
            int max = numbers.last(); // O(1)
            minDeviation = Math.min(minDeviation, max - min);
            if((max&1)==0) // if max number is even, we can reduce to half
            {
                numbers.remove(max); // logn
                numbers.add(max/2); // nlogm
            }
        }
        minDeviation = Math.min(minDeviation, numbers.last() - numbers.first());
        return minDeviation;
    }
    private boolean isOdd(int number) {
        return (number & 1) == 1;
    }
}

/*
        1 2 3 4
        
        2 2 2 3
        
        deviation = 4 2

*/