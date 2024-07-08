// my code

class State {
    int mask, index;
    public State(int mask, int index) {
        this.mask = mask;
        this.index = index;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.mask, this.index);
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        State s = (State) o;
        return this.mask == s.mask && this.index == s.index;
    }
}

class Solution {
    
    List<Integer> answer;
    Map<State, List<Integer>> dp;
    
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillIndex = new HashMap<>();
        int n = req_skills.length;
        // map skills with the index
        for(int i = 0; i < n; i++) {
            skillIndex.put(req_skills[i], i);
        }
        
        // set the bit of all the skills a person can contribute to
        int pl = people.size();
        int[] personSkills = new int[pl];
        int idx = 0;
        for(List<String> skillSet : people) {
            for(String skill : skillSet) {
                personSkills[idx] |= (1 << skillIndex.get(skill));
            }
            idx++;
        }
        
        answer = new ArrayList<>();
        dp = new HashMap<>();
        smallestTeam(personSkills, 0, 0, pl, n, new ArrayList<>()); // currSkillCount, index, pl, req_skills
        
        int l = answer.size();
        int[] result = new int[l];
        
        for(int i = 0; i < l; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
    
    private void smallestTeam(int[] personSkills, int currSkill, int index, int peopleLength, int req_skills_length, List<Integer> temp) {
        // base case
        if(index == peopleLength) {
            if(Integer.bitCount(currSkill) == req_skills_length) {
                if(answer.size() == 0 || temp.size() < answer.size()) {
                    answer = new ArrayList<>(temp);
                }
            }
            return;
        }
        
        State state = new State(currSkill, index);
        if(dp.containsKey(state)) {
            List<Integer> cached = dp.get(state);
            if(cached.size() <= temp.size()) 
                return;
        }
        
        // consider current person
        int newSkillSet = currSkill | personSkills[index];
        if(Integer.bitCount(newSkillSet) > Integer.bitCount(currSkill)) {
            temp.add(index);
            smallestTeam(personSkills, newSkillSet, index + 1, peopleLength, req_skills_length, temp);
            temp.remove(temp.size() - 1);   
        }
        
        // do not consider current person
        smallestTeam(personSkills, currSkill, index + 1, peopleLength, req_skills_length, temp);
        
        if(!dp.containsKey(state) || dp.get(state).size() > temp.size()) {
            dp.put(state, new ArrayList<>(temp));
        }
    }
}