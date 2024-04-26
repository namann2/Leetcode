if(atlantic[i][j] == true && pacific[i][j] == true)
result.add(List.of(i, j));
}
}
return result;
}
private void dfs(int[][]g, int i, int j, int n, int m, int cf, boolean[][]vis) {
​
boolean isCurrentCellSafe = isSafe(g, i, j, n, m, cf, vis);
if(isCurrentCellSafe) {
vis[i][j] = true;
dfs(g, i+1, j, n, m, g[i][j], vis);
dfs(g, i-1, j, n, m, g[i][j], vis);
dfs(g, i, j-1, n, m, g[i][j], vis);
dfs(g, i, j+1, n, m, g[i][j], vis);
}
}
// from a particular cell, we could go to a cell with value <= current value. but here,
// since we are traversing from the oceans hence condition is reversed
private boolean isSafe(int[][]g, int i, int j, int n, int m, int cf, boolean[][] vis) {
if(i>=0 && i<n && j>=0 && j<m && g[i][j] >= cf && !vis[i][j])
return true;
return false;
}
}
```