package dsa.linkedlist.main;



/*
    1  - 2   - 3
    |    |
    3    9
    |
    7
 */
public class NodeSLWithDown {
    public NodeSLWithDown next;
    public NodeSLWithDown down;
    public int data;

    public NodeSLWithDown(int data) {
        this.data = data;
    }
}
