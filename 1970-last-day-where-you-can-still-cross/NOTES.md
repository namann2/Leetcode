Time complexity : 

1. ​Binary Search: The binary search is performed on the range of days from 0 to the maximum possible day. It has a time complexity of O(log N), where N is the maximum possible day.

2. DFS Traversal: The DFS traversal explores the grid to check if there exists a path from the top row to the bottom row. In the worst case, it may traverse all cells of the grid. Since each cell is visited only once, the time complexity of DFS traversal is O(row * col), where row and col are the dimensions of the grid.

Combining both:

Binary Search: `O(log N)`
DFS Traversal: `O(row * col)`

So, the overall time complexity of the solution is `O((row * col) * log N).`
