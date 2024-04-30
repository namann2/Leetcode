## Google Follow Up :​

now consider, we do not want to save the numbers of stream and we are ok with some approximation of the median. Say, if the median of stream comes out to be 5, we are ok with nearest power of 2, be it 4 or 8.
How can we do this ?


### Solution : 

If you're dealing with a data stream and only need an approximate median as the nearest power of 2, you can utilize a simpler approach that avoids storing the actual numbers. Here's how:

1. **Maintain Two Counters:**
   - `count_less_than`: This counter keeps track of the number of elements seen in the stream that are **less than** an unknown current median value.
   - `count_more_than`: This counter keeps track of the number of elements seen in the stream that are **greater than** the unknown current median value.

2. **Update Counters on New Element:**
   - When a new element arrives in the stream, simply compare it to a current estimated median value (which can be initialized as any power of 2).
     - If the new element is **less than** the estimated median, increment `count_less_than`.
     - If the new element is **greater than** the estimated median, increment `count_more_than`.

3. **Estimate Approximate Median:**
   - You don't need to know the exact median value, just its nearest power of 2. 
   - Track the difference between the two counters: `difference = count_more_than - count_less_than`.
     - If `difference` is positive (more elements greater than estimated median), the actual median is likely **higher** than the current estimate. 
     - If `difference` is negative (more elements less than estimated median), the actual median is likely **lower** than the current estimate.
   - Based on the sign of `difference`, adjust the estimated median by moving to the nearest higher or lower power of 2, respectively.

4. **Bound the Approximation:**
   -  There's no guarantee the estimated median will be the exact nearest power of 2 to the true median. However, you can set a threshold for the difference between the counters.
   - If `difference` exceeds a certain value (positive or negative), you can adjust the estimated median by a larger step (e.g., two powers of 2) to catch up faster.

**Benefits:**

- This approach is memory-efficient as it only uses counters, not storing the actual stream elements.
- It provides an approximate median as the nearest power of 2, which can be sufficient for many applications.
- The time complexity for adding elements and updating the estimate is constant (O(1)).

**Trade-offs:**

- The accuracy of the approximation depends on the chosen thresholds and the distribution of the data stream.
- You lose information about the actual values in the stream.

This approach is a good compromise when memory is limited and an exact median is not crucial. You can adjust the threshold values and step size for adjusting the estimate based on your desired level of accuracy and trade-off with memory usage.



```

public class ApproximateMedian {

    private int estimatedMedian; // Stores the current estimated median (power of 2)
    private int countLessThan;   // Count of elements less than estimated median
    private int countMoreThan;  // Count of elements greater than estimated median
    private final int threshold; // Threshold for counter difference

    public ApproximateMedian(int initialMedian, int threshold) {
        this.estimatedMedian = initialMedian;
        this.countLessThan = 0;
        this.countMoreThan = 0;
        this.threshold = threshold;
    }

    public void addElement(int element) {
        if (element < estimatedMedian) {
            countLessThan++;
        } else {
            countMoreThan++;
        }

        updateEstimate();
    }

    public int getApproximateMedian() {
        return estimatedMedian;
    }

    private void updateEstimate() {
        int difference = countMoreThan - countLessThan;

        if (difference > threshold) {
            // Estimated median is too low, increase by 2 powers of 2
            estimatedMedian = estimatedMedian << 2;
        } else if (difference < -threshold) {
            // Estimated median is too high, decrease by 2 powers of 2
            estimatedMedian = estimatedMedian >> 2;
        } else {
            // Difference within threshold, adjust by 1 power of 2 for efficiency
            if (difference > 0) {
                estimatedMedian = estimatedMedian << 1;
            } else if (difference < 0) {
                estimatedMedian = estimatedMedian >> 1;
            }
        }
    }
}

```
