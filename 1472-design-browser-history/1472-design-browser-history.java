class Node {
    String url;
    Node prev, next;
    Node(String url) {
        this.url = url;
    }
}
class BrowserHistory {

    private Node tab;
    public BrowserHistory(String homepage) {
        tab = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newUrl = new Node(url);
        tab.next = newUrl;
        newUrl.prev = tab;
        tab = newUrl;
    }
    
    public String back(int steps) {
        while(steps-- > 0 && tab.prev != null)
            tab = tab.prev;
        return tab.url;
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && tab.next != null)
            tab = tab.next;
        return tab.url;
    }
}
