class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long answer = 0;
        int n = values.length, i = 0;
        boolean[] visited = new boolean[n];
        while(i >= 0 && i < n) {
            if(visited[i]) return answer;
            visited[i] = true;
            if(instructions[i].equals("jump")) {
                i += values[i];
            } else {
                answer += (1L * values[i]);
                i++;
            }
        }
        return answer;
    }
}