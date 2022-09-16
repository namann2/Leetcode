# Thought Process :
​
We need to find the subarrays with `exactly` k different characters.
​
* This is a follow-up/ extension to the logic of [Atmost 2 different Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/)
​
The very first idea is to use the sliding window technique, there is no tough stop there.
​
But this idea soon takes a toll. How ?
eg : `1 2 1 1 2 3`, k = 2
​
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
Required :
​
We can explicitly count the number of sub-arrays with `atmost k-1` different characters.
`exactlyKCharacter = atmostKCharacters - atmostK-1Characters`