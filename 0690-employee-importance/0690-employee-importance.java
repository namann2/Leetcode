/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        return getImportance(map, id);
    }
    
    private int getImportance(HashMap<Integer, Employee> map, int id) {
        int importance = 0;
        importance += map.get(id).importance;
        
        Employee emp = map.get(id);
        for(int sub_id : emp.subordinates) {
            importance += getImportance(map, sub_id);
        }
        return importance;
    }
}