While applying sliding window we get to know that we are unable to get the
sub-subarrays which has exactly `k` different characters. How do we do that ? How
can we count the number of sub-subarrays with exactly `k` different characters ?
For the sub-subarrays, the size of subarray with `exactly k` different characters would lie in range [1,end-begin+1]. For eg :
`1, 2, 1, 1, 2` is a bigger subarray. The possible sub-subarrays with exactly k different characters are :
`[1,2]` &  `[2,1]` &  `[1,1]`  &  `[1,2]` - sub-subarrays of size 2
`[1,2,1]` - sub-subarrays of size 3
`[1,2,1,1]` - sub-subarrays of size 4
​
We can explicitly count the number of sub-arrays with `atmost k` different characters
We can explicitly count the number of sub-arrays with `atmost k-1` different characters.
​
### Required :
​
`exactlyKCharacter = atmostKCharacters - atmostK-1Characters`
​
The expression "atmost(k) - atmost(k-1)" refers to the difference between the number of elements that occur at most k times in a dataset and the number of elements that occur at most (k-1) times in the same dataset. This can be used in various contexts, such as frequency analysis, statistics, or algorithmic analysis.
​
Let's break down what "atmost(k)" means in this context:
​
"atmost(k)": This represents the count of elements in the dataset that occur at most k times. For example, if k=3, "atmost(3)" would count all elements that occur 1, 2, or 3 times in the dataset.
Now, when you subtract "atmost(k-1)" from "atmost(k)", you are essentially calculating the difference in counts of elements that occur at most k times and those that occur at most (k-1) times.
​
For example, let's say you have a dataset with elements and their frequencies:
​
Element A occurs 3 times.
Element B occurs 2 times.
Element C occurs 1 time.
Element D occurs 4 times.
Element E occurs 2 times.
If you calculate "atmost(3) - atmost(2)", it means you count the elements that occur at most 3 times (A, B, C, D) and subtract from it the count of elements that occur at most 2 times (B, C, E). So, the result would be 4 - 3 = 1, indicating that there is 1 element (which is A in this case) that occurs exactly 3 times.
​
In general, "atmost(k) - atmost(k-1)" helps you analyze the distribution of frequencies of elements in a dataset, especially when you want to focus on elements that occur a specific number of times (e.g., exactly k times).