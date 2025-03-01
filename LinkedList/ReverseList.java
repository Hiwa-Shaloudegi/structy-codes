package LinkedList;

class ReverseList {
    public static void main(String[] args) {}

    public static <T> Node<T> reverseList(Node<T> head) {
        Node<T> back = null;
        var curr = head;
        var front = head.next;


        // loop
        while (front != null) {
            curr.next = back;

            back = curr;
            curr = front;
            front = front.next;
        }
        curr.next = back;
        return curr;
    }

    //  Recursive
    public static <T> Node<T> reverseListRecursive(Node<T> head) {
        if (head == null) return null;
        if (head.next == null) return head;

        var newHead = reverseListRecursive(head.next);
        Node<T> temp = newHead;
        while (temp.next != null) {

            temp = temp.next;
        }
        temp.next = head;
        head.next = null;

        return newHead;
    }
}
