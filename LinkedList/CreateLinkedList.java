package LinkedList;

import java.util.Arrays;

class CreateLinkedList {
    public static void main(String[] args) {
        System.out.println(createLinkedListRecursive(new Integer[]{4, 5, 6}).showValues());
    }


    public static <T> Node<T> createLinkedList(T[] array) {
        Node<T> head = null;
        Node<T> cur = head;

        for (T e : array) {
            Node<T> newNode = new Node<>(e);
            if (cur != null) cur.next = newNode;
            cur = newNode;
            if (head == null) head = newNode;
        }

        return head;
    }

    public static <T> Node<T> createLinkedList2(T[] array) {
        Node<T> firstNode = new Node<>(array[0]);

        Node<T> head = firstNode;
        Node<T> cur = head;

        for (int i = 1; i < array.length; i++) {
            Node<T> newNode = new Node<>(array[i]);
            cur.next = newNode;
            cur = cur.next;
        }
        return head;
    }


    // Recursive
    public static <T> Node<T> createLinkedListRecursive(T[] array) {
        if (array.length == 0) return null;
        if (array.length == 1) return new Node<>(array[0]);

        T[] subarray = Arrays.copyOfRange(array, 1, array.length);
        Node<T> resHead = createLinkedListRecursive(subarray);
        Node<T> head = new Node<T>(array[0]);
        head.next = resHead;

        return head;

    }
}
