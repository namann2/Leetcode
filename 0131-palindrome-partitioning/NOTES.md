## Detailed explanation of runtime complexity

[ Learning : If we have a string of length n -> total number of partitions are : 2^n ]

1. A string of length N will have (N, N-1, N-2, ...,1) substrings at positions (0, 1, 2, ..., N-1) respectively. So the total number of substrings of a string is N+N-1+...+1 = O(N2). It is not exponential.

2. The number 2^N in complexity analysis above is in fact the number of nodes in the search tree - not the number of substrings. It is the number of possible partitionings (each partitioning is a way to partition the string into substrings).
   This can be derived as follows -
   
    - Imagine the string as a sequence of N chars separated by a pipe between neighbors, such as a string “abcde” = a|b|c|d|e. 
    Such a representation will have N-1 pipes - in this example, 4 pipes.

    - If you want the partitioning to have 4 substrings, then you can ask, “how many ways can I select 3 pipes out of the 4 pipes?” - answer is 4 choose 3, i.e. 4C3 = 4. The 4 ways to partition are: { {“a”, “b”, “c”, “de”}, {“a”, “b”, “cd”, “e”}, {“a”, “bc”, “d”, “e”}, {“ab”, “c”, “d”, “e”}
    Arguing like the above, the total number of ways to partition this example is when we ask all questions “how many ways can I select 0 or 1 or 2 or 3 or 4 pipes?” = 4C0 + 4C1 + 4C2 + 4C3 + 4C4 = 24 = 16 partitionings

    - In general a string of length N will have N-1C0 + N-1C1 + ... +N-1CN-2 = 2N-1 = 2^N-1 = O(2^N) partitionings

3. For each partitioning, we do two things:

    - build the substrings for that partition
    - check whether each substring in that partitioning is a palindrome or not
    - Since the number of characters in each parititioning is N, cost of the above operations is N+N = 2.N = O(N)
    - Later, in Approach 2, when we improve the logic using dynamic programming, it does not change the overall complexity, since we would still need to build the substrings!

4. Combining 2&3 above, we get O(N.2N)
