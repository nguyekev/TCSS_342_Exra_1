public class MyLinkedList<Type> {

    private class Node {
        public Type item;
        public Node next;

        public Node(Type item) {
            this.item = item;
            this.next = null;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    private Node prev = null;
    private Node cur = null;
    private Node first = null;
    private int size = 0;
    public long comparisons;

    public void addBefore(Type item){
        Node temp = new Node(item);

        if(cur == first){
            first = temp;
            prev = first;
            prev.next = cur;
        } else{
            temp.next = cur;
            prev.next = temp;
            prev = prev.next;

        }
        size++;
    }

    public void addFirst(Type item) {
        first = new Node(item);
        prev = first;
        size++;
    }

    public void addLast(Type item) {
        Node tempNode = new Node(item);
        prev.next = tempNode;
        prev = tempNode;
    }

    public Type remove() {
        Type result = current();
        if (cur == null) {
            return null;
        }
        if (cur == first) {
            cur = cur.next;
            prev = cur;
            first = cur;
            size--;
        } else {
            cur = cur.next;
            prev.next = cur;
            size--;
        }
        return result;
    }

    public Type current() {
        if (cur == null) {
            return null;
        } else {
            return cur.item;
        }
    }

    public Type first() {
        if (first == null) {
            return null;
        } else {
            cur = first;
            prev = first;
            return cur.item;
        }
    }

    public Type next() {
        if (cur == null) {
            return null;
        } else {
            prev = cur;
            cur = cur.next;
            return current();
        }
    }

    public boolean contains(Type item) {
        Node tempNode = first;
        while (tempNode.item != item) {
            if (tempNode.next == null) {
                return false;
            }
            tempNode = tempNode.next;
        }
        return true;
    }

    public void addToLast(Type item) {
        Node tempNode = new Node(item);
        if (first == null) {
            first = tempNode;
            prev = first;
        } else {
            prev.next = tempNode;
            prev = tempNode;
        }
        size++;
    }

    public void addToFront(Type item) {
        Node tempNode = new Node(item);
        tempNode.next = first;
        first = tempNode;
        prev = first;
        size++;
    }

    public void moveToFront() {
        if (cur != first) {
            Node tempNode = new Node(cur.item);
            tempNode.next = first;
            first = tempNode;
            prev.next = cur.next;
            cur.next = first.next;
        }
    }

    public void swapWithPrevious() {
        Node tempNode1 = new Node(cur.item);
        Node tempNode2 = new Node(prev.item);
        cur.item = tempNode2.item;
        prev.item = tempNode1.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.item);
            if (temp.next != null) {
                sb.append(", ");
            }
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}