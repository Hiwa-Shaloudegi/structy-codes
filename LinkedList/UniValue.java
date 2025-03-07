package LinkedList;

class UniValue {
    public static void main(String[] args) {
        Node<Integer> a = new Node<>(7);
        Node<Integer> b = new Node<>(7);
        Node<Integer> c = new Node<>(7);
        Node<Integer> d = new Node<>(7);
        Node<Integer> e = new Node<>(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(isUniValueListRecursive(a));
    }

    public static <T> boolean isUniValueList(Node<T> head) {
        T value = head.val;

        Node<T> cur = head;
        while (cur != null) {
            if (cur.val != value) return false;
            cur = cur.next;
        }

        return true;
    }

    // Recursive
    public static <T> boolean isUniValueListRecursive(Node<T> head) {
        if (head == null) return true;
        if (head.next == null) return true;
        return (head.val == head.next.val) && isUniValueListRecursive(head.next);

    }


}
