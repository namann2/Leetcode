class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        contructGraph(map, pid, ppid);
        dfs(map, kill, new HashSet<>(), answer);
        return answer;
    }
    private void contructGraph(Map<Integer, Set<Integer>> map, List<Integer> pid, List<Integer> ppid) {
        int n = ppid.size();
        for(int i=0;i<n;i++) {
            map.putIfAbsent(ppid.get(i), new HashSet<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
    }
    private void dfs(Map<Integer, Set<Integer>> map, int src, Set<Integer> visited, List<Integer> answer) {
        
        visited.add(src);
        answer.add(src);
        
        if(map.containsKey(src)) {
            for(Integer node : map.get(src)) {
                if(!visited.contains(node)) {
                    dfs(map, node, visited, answer);
                }
            }
        }
    }
}