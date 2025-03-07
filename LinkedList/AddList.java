package LinkedList;

class AddList {
    public static void main(String[] args) {
        // Test case 1
        //                        var a = new Node<Integer>(2);
        //                        var b = new Node<Integer>(4);
        //                        var c = new Node<Integer>(8);
        //
        //                        var d = new Node<Integer>(7);
        //                        var e = new Node<Integer>(6);
        //                        var f = new Node<Integer>(9);
        //                        a.next = b;
        //                        b.next = c;
        //
        //                        d.next = e;
        //                        e.next = f;

        // Test case 2
        var a = new Node<Integer>(9);
        var b = new Node<Integer>(9);
        var c = new Node<Integer>(9);

        var d = new Node<Integer>(6);
        a.next = b;
        b.next = c;

        // Test case 3
        //        var a = new Node<Integer>(9);
        //        var b = new Node<Integer>(8);
        //
        //        var c = new Node<Integer>(7);
        //        var d = new Node<Integer>(4);
        //        a.next = b;
        //
        //        c.next = d;


        // Test case 4
        //        var a = new Node<Integer>(9);
        //        var b = new Node<Integer>(2);
        //        var c = new Node<Integer>(5);
        //        var d = new Node<Integer>(9);
        //        var e = new Node<Integer>(9);
        //
        //        var x = new Node<Integer>(7);
        //        var y = new Node<Integer>(5);
        //        var z = new Node<Integer>(3);
        //        var n = new Node<Integer>(6);
        //        a.next = b;
        //        b.next = c;
        //        c.next = d;
        //        d.next = e;
        //
        //        x.next = y;
        //        y.next = z;
        //        z.next = n;

        System.out.println(addList(a, d).showValues());
    }


    // Todo: There's a simpler version -> Alvin solution
    public static Node<Integer> addList(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> cur1 = head1;
        Node<Integer> cur2 = head2;
        Node<Integer> dummyHead = new Node<>(0);
        Node<Integer> cur3 = dummyHead;
        int carry = 0;

        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + carry;
            carry = 0;
            if (sum >= 10) {
                int ones = sum % 10;
                carry = (sum / 10) % 10;
                sum = ones;

            }
            Node<Integer> newNode = new Node<>(sum);
            cur3.next = newNode;
            cur3 = cur3.next;

            if (cur1.next == null && cur2.next != null) {
                cur1.next = new Node<>(0);

            }
            if (cur2.next == null && cur1.next != null) {
                cur2.next = new Node<>(0);
            }

            // 1) if we had final carry
            if (cur1.next == null && cur2.next == null && carry != 0) {
                cur1.next = new Node<>(0);
                cur2.next = new Node<>(0);
            }

            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //        // 2) if we had final carry
        //        if (carry != 0) {
        //            Node<Integer> newNode = new Node<>(carry);
        //            cur3.next = newNode;
        //        }

        return dummyHead.next;
    }


    // Recursive
    // Todo: Fix it
    public static Node<Integer> addListRecursive(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null && head2 == null) return null;
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.next == null && head2.next == null) {
            int sum = head1.val + head2.val;
            if (sum >= 10) {
                int ones = sum % 10;
                int tens = (sum / 10) % 10;

                Node<Integer> onesNode = new Node<>(ones);
                Node<Integer> tensNode = new Node<>(tens);
                onesNode.next = tensNode;

                return onesNode;

            }
            return new Node<>(sum);
        }

        Node<Integer> resNode = addListRecursive(head1.next, head2.next);

        int sum = head1.val + head2.val;
        if (sum >= 10) {
            int ones = sum % 10;
            int tens = (sum / 10) % 10;

            Node<Integer> onesNode = new Node<>(ones);
            onesNode.next = resNode;
            resNode.val += tens;

            return onesNode;
        } else {
            Node<Integer> newSumNode = new Node<>(sum);
            newSumNode.next = resNode;
            return newSumNode;
        }

    }

    public static Node<Integer> addListRecursiveAlvin(Node<Integer> head1, Node<Integer> head2, int carry) {
        if (head1 == null && head2 == null && carry == 0) return null;
        int val1 = head1 == null ? 0 : head1.val;
        int val2 = head2 == null ? 0 : head2.val;

        int sum = val1 + val2 + carry;
        int nextCarry = sum > 9 ? 1 : 0;
        int digit = sum % 10;

        Node<Integer> resultNode = new Node<>(digit);

        Node<Integer> next1 = head1 == null ? null : head1.next;
        Node<Integer> next2 = head2 == null ? null : head2.next;

        resultNode.next = addListRecursiveAlvin(next1, next2, nextCarry);
        return resultNode;

    }
}
