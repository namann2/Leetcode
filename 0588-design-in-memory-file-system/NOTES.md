The time complexity of executing an `ls` command is `O(m+n+klog(k))`. Here, 

- m refers to the length of the input string. We need to scan the input string once to split it and determine the various levels. <br>
- n refers to the depth of the last directory level in the given input for ls. This factor is taken because we need to enter n levels of the tree structure to reach the last level. <br>
- k refers to the number of entries(files+subdirectories) in the last level directory(in the current input). We need to sort these names giving a factor of 
klog(k).<br>

The time complexity of executing an `mkdir` command is `O(m+n)`. Here, 
- m refers to the length of the input string. We need to scan the input string once to split it and determine the various levels. 
- n refers to the depth of the last directory level in the mkdir input. This factor is taken because we need to enter n levels of the tree structure to reach the last level.

The time complexity of both `addContentToFile` and `readContentFromFile` is `O(m+n)`. Here, 
- m refers to the length of the input string. We need to scan the input string once to split it and determine the various levels. 
- n refers to the depth of the file name in the current input. This factor is taken because we need to enter n levels of the tree structure to reach the level where the files's contents need to be added/read from.


```

class FileSystem {

    private Node root;
    
    public FileSystem() {
        root = new Node();    
    }
    
    public List<String> ls(String path) {
        Node curr = root;
        // TODO : implement traverse 
        curr = traverse(curr, path);
        if(curr.isFile)
            return List.of(curr.name);
        return new ArrayList<>(curr.children.keySet());
    }
    
    public void mkdir(String path) {
        // TODO : implement insert
        insert(root, path, false); 
    }
    
    public void addContentToFile(String filePath, String content) {
        insert(root, filePath, true);
        Node curr = traverse(root, filePath);
        curr.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        Node curr = root;
        curr = traverse(curr, filePath);
        return curr.content.toString();
    }
    
    /* HELPER FUNCTIONS */
    
    private Node traverse(Node curr, String path) {
        String[] intermediates = path.split("/");
        int n = intermediates.length;
        for(int i = 1; i < n; i++) {
            curr = curr.children.get(intermediates[i]);
        }
        return curr;
    }
    
    private void insert(Node curr, String path, boolean isFile) {
        String[] intermediates = path.split("/");
        int n = intermediates.length;
        for(int i = 1; i < n; i++) {
            if(!curr.children.containsKey(intermediates[i])) {
                Node node = new Node();
                node.name = intermediates[i];
                curr.children.put(intermediates[i], node);
            }
            curr = curr.children.get(intermediates[i]);
        }
        if(isFile) curr.isFile = true;
    }
}

class Node {
    TreeMap<String, Node> children; // directory
    String name;
    StringBuilder content;
    boolean isFile;
    Node() {
        children = new TreeMap<>();
        content = new StringBuilder();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
```​
