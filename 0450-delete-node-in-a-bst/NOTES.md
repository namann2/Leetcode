Time complexity :
O(logN).
During the algorithm execution we go down the tree all the time - on the left or on the right, first to search the node to delete and then to actually delete it.
H1 is a tree height from the root to the node to delete. The delete process takes H2 time, where is a tree height from the root to delete to the leaves.
That in total results in O(H1) + O(H2)=O(H) time complexity, where H is a tree height, equal to logN in the case of the balanced tree.
​
Space complexity :
O(H) to keep the recursion stack, where H is a tree height.
H=logN for the balanced tree.