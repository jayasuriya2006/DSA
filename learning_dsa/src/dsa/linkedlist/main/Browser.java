package dsa.linkedlist.main;

public class Browser {

    public BrowserNode currentTab;

    //home page
    public Browser(String url) {
        this.currentTab = new BrowserNode(url);
    }

    public BrowserNode visit(String url) {
        BrowserNode newTab = new BrowserNode(url);
        this.currentTab.next = newTab;
        newTab.prev = this.currentTab;
        this.currentTab = newTab;
        return this.currentTab;
    }

    public BrowserNode back(int steps) {

        BrowserNode temp = this.currentTab;
        while (temp.prev != null && steps > 0) {
            temp = temp.prev;
            steps--;
        }
        this.currentTab = temp;
        return this.currentTab;
    }

    public BrowserNode forward(int steps) {

        BrowserNode temp = this.currentTab;
        while (temp.next != null && steps > 0) {
            temp = temp.next;
            steps--;
        }
        this.currentTab = temp;
        return this.currentTab;
    }

}
