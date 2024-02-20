Total number of coins the tree has is equal to the number of nodes. We need to find the minimum number of moves and make sure every node has exactly 1 coin.
​
1. How can we guarantee minimum number of moves ?
If at every node, I decide to satisfy the coins of the children nodes first and then the current root then I can make sure that the number of moves will be minimum. Why ? Because then I can worry to satisfy the nodes that are upper in the level and we will not need to move extra steps, down the tree to satisfy the nodes that are deep.