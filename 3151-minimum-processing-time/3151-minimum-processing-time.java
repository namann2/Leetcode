class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);

        int processorLength = processorTime.size();
        int taskIndex = tasks.size() - 1, timeRequired = 0;
        for(int processor = 0; processor < processorLength; processor++) {
            timeRequired = Math.max(timeRequired, processorTime.get(processor) + tasks.get(taskIndex));
            taskIndex -= 4;
        }
        return timeRequired;
    }
}