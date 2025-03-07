package LinkedList;

class MergeLists {
    public static void main(String[] args) {
        var a = new Node<Integer>(5);
        var b = new Node<Integer>(6);
        var c = new Node<Integer>(7);
        var d = new Node<Integer>(10);
        var e = new Node<Integer>(12);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        var x = new Node<Integer>(1);
        var y = new Node<Integer>(15);
        x.next = y;


        Node<Integer> res = mergeLists(a, x);
        System.out.println(res.showValues());
    }


    public static Node<Integer> mergeLists(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> cur1 = head1;
        Node<Integer> cur2 = head2;
        Node<Integer> resHead = new Node<>(0);
        Node<Integer> curRes = resHead;  // tail


        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                curRes.next = cur1;
                cur1 = cur1.next;
            } else {
                curRes.next = cur2;
                cur2 = cur2.next;
            }
            curRes = curRes.next;
        }

        if (cur1 == null) curRes.next = cur2;
        if (cur2 == null) curRes.next = cur1;

        return resHead.next;

    }


    // Recursive
    public static Node<Integer> mergeListsRecursive(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null && head2 == null) return null;
        if (head1 == null) return head2;
        if (head2 == null) return head1;


        Node<Integer> resHead = mergeListsRecursive(head1.next, head2.next);
        Node<Integer> nodeToInsert = null;
        if (head1.next.val.equals(resHead.val)) {
            head1.next = resHead;
            resHead = head1;
            nodeToInsert = head2;
        } else {
            head2.next = resHead;
            resHead = head2;
            nodeToInsert = head1;
        }

        // Insert node
        Node<Integer> cur = resHead;
        Node<Integer> prev = null;
        while (cur != null) {
            if (nodeToInsert.val < cur.val) {
                nodeToInsert.next = cur;
                if (prev != null) {
                    prev.next = nodeToInsert;
                } else {
                    return nodeToInsert;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        // for inserting to the last
        if (prev.next == null) {
            prev.next = nodeToInsert;
        }
        return resHead;
    }

    public static Node<Integer> mergeListsSimpleRecursive(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null && head2 == null) return null;
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.val < head2.val) {
            head1.next = mergeListsSimpleRecursive(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeListsSimpleRecursive(head1, head2.next);
            return head2;
        }
    }

}
