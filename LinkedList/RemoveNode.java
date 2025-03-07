package LinkedList;

class RemoveNode {
    public static void main(String[] args) {

        var a = new Node<String>("a");
        var b = new Node<String>("b");
        var c = new Node<String>("c");
        var d = new Node<String>("d");
        var e = new Node<String>("e");
        var f = new Node<String>("f");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(removeNodeRecursive(a, "d").showValues());
    }


    public static <T> Node<T> removeNode(Node<T> head, T target) {
        // Edge Case: if the target is the first node of the linked list
        if (head.val == target) return head.next;

        Node<T> prev = head;
        Node<T> cur = head.next;

        while (cur != null) {
            if (cur.val != target) prev = prev.next;
            else {
                prev.next = cur.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }


    // Recursive
    public static <T> Node<T> removeNodeRecursive(Node<T> head, T target) {
        if (head == null) return null;
        if (head.next == null && head.val.equals(target)) return null;
        if (head.next == null) return head;

        Node<T> resHead = removeNodeRecursive(head.next, target);

        if (head.val.equals(target)) {
            return resHead;
        } else {
            head.next = resHead;
            return head;
        }
    }
}
