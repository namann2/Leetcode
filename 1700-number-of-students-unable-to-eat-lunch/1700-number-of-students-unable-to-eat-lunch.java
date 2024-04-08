class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> student = new ArrayDeque<>();
        Deque<Integer> sandwich = new ArrayDeque<>();
        int n = students.length;
        for(int i=0;i<n;i++) {
            student.addLast(students[i]);
            sandwich.addLast(sandwiches[i]);
        }
        
        int cnt = 0;
        while(cnt != student.size()) {
            if(student.peekFirst() != sandwich.peekFirst()) {
                cnt++;
                student.addLast(student.removeFirst());
            } else {
                cnt = 0;
                student.removeFirst();
                sandwich.removeFirst();
            }
        }
        return student.size();
    }
}