Minimum diff between any two node in a bst can be only found from the adjacent nodes. Doing inorder traversal, we will have the sorted format of all numbers, we can then find the difference between them to find the min.

We can save the space of storing all the numbers. How and why ?
Since for a current node, we only require the previous element that should be there
in the inorder traversal, all we need to do is to get the previous element for the current node.
In a recursive fashion, this is a bit cloudy in my head but i can do it easily with iterative.​
