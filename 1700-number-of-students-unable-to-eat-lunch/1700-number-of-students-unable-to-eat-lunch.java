class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zero = 0, one = 0, n = students.length;
        for(int i = 0;i < n; i++) {
            if(students[i] == 0) zero++;
            else one++;
        }
        
        for(int i = 0; i < n; i++) {
            if(sandwiches[i] == 0) {
                if(zero > 0) zero--;
                else return n - i;
            } else {
                if(one > 0) one--;
                else return n - i;
            }
        }
        return 0;
    }
}