There are 3 ways to solve this :
1. HashMap => Space Complexity : O(n) , Time : O(1)
2. Bit Masking => Space : Constant , Time : O(n*log n)
3. Moore's Voting Algorithm =>  Dope algorithm
Moore's Voting Algorithm :
[ Keep in mind that, we are comparing the votes of other candidates in the array respective to the majorityElement ]
​
Choose the first element as the *majorityElement* and declare the *voteCount* of it as 1.
Now, the conditions :
[ Loop through the elements, from index 1 till the end of array ]
​
Step 1. Check if the current element is equal to the majorityElement =>
1.1 If  [ YES ] =>  this means that the [ current majorityElement gets another vote ], so increment the voteCount
1.2 If [ NO ] => this means that some other candidate got the vote. So, we decrement the voteCount of our majorityElement.
1.2 a) After decrementing the count, we check whether the voteCount of our majorityElement is 0 or not. If it is zero, this means some other candidate[ the current element of array ] got votes more than the majorityElement [ we cancelled the votes by decrementing the count ] and now, he has to be made the majorityElement, so we update our majorityElement and set its voteCount to 1.
​
Step 2.  Check the voteCount for confirmation that we got a winner
Check if the voteCount is >n/2