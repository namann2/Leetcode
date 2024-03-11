class RandomizedCollection {

    private HashMap<Integer, Set<Integer>> hashmap;
    private List<Integer> locations;

    public RandomizedCollection() {
        hashmap = new HashMap<>();
        locations = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean contains = hashmap.containsKey(val);
        int size = locations.size();
        if (contains) {
            hashmap.get(val).add(size);
            locations.add(val);
            return false;
        } else {
            hashmap.put(val, new HashSet<>());
            hashmap.get(val).add(size);
            locations.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        boolean contains = hashmap.containsKey(val);
        if (contains) {
            Set<Integer> indices = hashmap.get(val);
            if (indices.size() == 0)
                return false;
            int indexToRemove = indices.iterator().next();
            int lastIndex = locations.size() - 1;
            int lastValue = locations.get(lastIndex);
            indices.remove(indexToRemove);
            if (indexToRemove < lastIndex) {
                locations.set(indexToRemove, lastValue);
                hashmap.get(lastValue).remove(lastIndex);
                hashmap.get(lastValue).add(indexToRemove);
            }
            locations.remove(lastIndex);
            if (indices.size() == 0)
                hashmap.remove(val);
            else
                hashmap.put(val, indices);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int min = 0, max = locations.size();
        int index = (int) (Math.random() * (max - min) + min);
        return locations.get(index);
    }
}
