<h2>  Frog Position After T Seconds</h2><hr><div><p>Given an undirected tree consisting of n vertices numbered from 1 to n. A frog starts jumping from vertex 1. In one second, the frog jumps from its current vertex to another unvisited vertex if they are directly connected. The frog can not jump back to a visited vertex. In case the frog can jump to several vertices, it jumps randomly to one of them with the same probability. Otherwise, when the frog can not jump to any unvisited vertex, it jumps forever on the same vertex.</p>

<p><em>The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi.</em></p>

<p><em>Return the probability that after t seconds the frog is on the vertex target. Answers within 10-5 of the actual answer will be accepted.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/12/21/frog1.jpg" style="width: 340px; height: 250px;"></p>

<pre><strong>Input:</strong> n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
<strong>Output:</strong> 0.16666666666666666 
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/12/21/frog2.jpg" style="width: 340px; height: 250px;"></p>

<pre><strong>Input:</strong> n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
<strong>Output:</strong> 0.3333333333333333
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>1 <= <code>n</code> <= 100</li>
	<li><code>edges.length == n - 1</code></li>
  <li><code>edges[i].length == 2</code></li>
  <li><code>1 <= ai, bi <= n</code></li>
  <li><code>1 <= t <= 50</code></li>
  <li><code>1 <= target <= n</code></li>
</ul>
</div>
