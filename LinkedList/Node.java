package LinkedList;

public class Node<T> {
    T val;
    Node<T> next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }

    public String showValues() {

        StringBuilder sb = new StringBuilder();

        Node<T> cur = this;
        while (cur != null) {
            sb.append(cur.val);
            sb.append(" -> ");
            cur = cur.next;
        }

        sb.append("null");
        return sb.toString();
    }
}
