package LinkedList;

import java.util.ArrayList;
import java.util.List;

class LinkedListValues {
    public static void main(String[] args) {}

    public static List<String> linkedListValues(Node<String> head) {
        List<String> result = new ArrayList<>();

        Node<String> curr = head;
        while (curr != null) {
            result.add(curr.val);
            curr = curr.next;
        }

        return result;
    }
}
