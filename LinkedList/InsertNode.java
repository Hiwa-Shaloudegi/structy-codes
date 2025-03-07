package LinkedList;

class InsertNode {
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

        System.out.println(insertNodeRecursive(a, "X", 0).showValues());
    }


    public static <T> Node<T> insertNode(Node<T> head, T value, int index) {
        Node<T> newNode = new Node<>(value);

        if (index == 0) {
            newNode.next = head;
            return newNode;
        }

        int i = 0;
        Node<T> cur = head;
        while (cur != null) {
            if (i == index - 1) {
                newNode.next = cur.next;
                cur.next = newNode;
                break;
            }
            i++;
            cur = cur.next;
        }
        return head;
    }


    // Recursive
    public static <T> Node<T> insertNodeRecursive(Node<T> head, T value, int index) {
        Node<T> newNode = new Node<>(value);

        // Edge Case
        if (head == null) return null;
        if (index == 0) {
            newNode.next = head;
            return newNode;
        }

        // Base Case
        if (head.next == null) {
            if (index >= 2) return head;
            if (index == 1) {
                head.next = newNode;
                return head;
            }
        }

        // Body
        head.next = insertNodeRecursive(head.next, value, --index);
        return head;

    }
}
