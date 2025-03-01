package LinkedList;

class GetNodeValue {
    public static void main(String[] args) {}

    public static <T> T getNodeValue(Node<T> head, int index) {
        int i = 0;

        Node<T> curr = head;
        while (curr != null) {
            if (i == index) {
                return curr.val;
            }
            i++;
            curr = curr.next;
        }
        return null;
    }

    public static <T> T getNodeValueRecursive(Node<T> head, int index) {
        // Edge case
        if (head == null) return null;
        // Base case
        if (index == 0) return head.val;

        int i = index - 1;
        return getNodeValueRecursive(head.next, i);
    }
}
