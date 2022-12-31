Complexity Analysis :
​
Suppose we reach a cell ( through dfs ), then at max we will have to traverse 3 more cells ( not 4 because we came to the current cell from this ).
​
TC : O(3^N), where N is total number of non obstacles cell
​
SC : O(nm)