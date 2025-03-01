package LinkedList;

class SumList {
    public static void main(String[] args) {}

    public static int sumList(Node<Integer> head) {
        int sum = 0;

        Node<Integer> curr = head;
        while (curr != null) {
            sum += curr.val;
            curr = curr.next;
        }
        return sum;
    }

    public static int sumListRecursive(Node<Integer> head) {
        if (head == null) return 0;

        return head.val + sumListRecursive(head.next);
    }
}
