package LinkedList;

class LinkedListFind {
    public static void main(String[] args) {}

    public static <T> boolean linkedListFind(Node<T> head, T target) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.val == target) return true;
            curr = curr.next;
        }
        return false;
    }

    public static <T> boolean linkedListFindRecursive(Node<T> head, T target) {
        if (head == null) return false;
        return (head.val == target) || linkedListFindRecursive(head.next, target);
    }
}
