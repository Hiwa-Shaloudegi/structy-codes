package LinkedList;

class LongestStreak {

    public static void main(String[] args) {
        var a = new Node<Integer>(5);
        var b = new Node<Integer>(5);
        var c = new Node<Integer>(7);
        var d = new Node<Integer>(7);
        var e = new Node<Integer>(7);
        var f = new Node<Integer>(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(longestStreak(a));

    }

    public static <T> int longestStreak(Node<T> head) {
        int res = 0; // Max streak

        int count = 0;
        Node<T> cur = head;
        while (cur != null) {
            if (head.val == cur.val) count++;
            else {
                if (count > res) res = count;
                count = 1;
                head = cur;
            }
            cur = cur.next;
        }

        return res;
    }

}
