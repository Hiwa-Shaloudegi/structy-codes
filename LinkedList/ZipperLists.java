package LinkedList;


class ZipperLists {
    public static void main(String[] args) {}


    public static <T> Node<T> zipperLists(Node<T> head1, Node<T> head2) {
        Node<T> curr1 = head1;
        Node<T> curr2 = head2;

        Node<T> temp2 = curr2.next;

        while (curr1 != null && curr2 != null) {
            if (curr1.next == null) {
                curr1.next = curr2;
                return head1;
            }

            curr2.next = curr1.next;
            curr1.next = curr2;
            curr1 = curr2.next;
            curr2 = temp2;
            if (temp2 != null) temp2 = temp2.next;

        }

        return head1;
    }

    // Recursive
    public static <T> Node<T> zipperListsRecursive(Node<T> head1, Node<T> head2) {
        if (head1 == null && head2 == null) return null;
        if (head1 == null && head2 != null) return head2;
        if (head1 != null && head2 == null) return head1;

        if (head1.next == null && head2.next == null) {
            head1.next = head2;
            return head1;
        }

        Node<T> resHead = zipperLists(head1.next, head2.next);
        head1.next = head2;
        head2.next = resHead;

        return head1;
    }
}

