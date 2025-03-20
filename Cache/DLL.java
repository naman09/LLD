public class DLL {
    private Node head;
    private Node tail;

    DLL() {
        head = null;
        tail = null;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public void addFront(String data) {
        Node x = new Node(data);
        head.prev = x;
        x.next = head;
        head = x;

        if (head.next == null) {
            this.tail = head;
        }
    }

    public void removeNode(Node node) {
        if (node == null) {
            return;
        }

        if (node.next == null) {
            this.tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        if (node.prev == null) {
            this.head = node.next;
        } else {
            node.prev.next = node.next;
        }

        node.next = null;
        node.prev = null;
    }
}
