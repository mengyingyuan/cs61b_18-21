public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node() {
            prev = null;
            next = null;
        }

        public Node(Node pre, T itm, Node n) {
            prev = pre;
            item = itm;
            next = n;
        }
    }

    // Creates an empty linked list deque.
    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node p = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
        size += 1;

    }

    public void addLast(T item) {
        Node p = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    //Prints the items in the deque from first to last, separated by a space
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    // Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return first;
    }

    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return last;
    }

    public T get(int index) {
        Node p = sentinel.next;
        for (int i = 0; i < index; i += 1) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        Node p = sentinel.next;
        return getRecursiveHelper(p, index);
    }	private void shrink(){
		if (size/ items.length)
	}



    private T getRecursiveHelper(Node p, int index) {
        if (index == 0) {
            return p.item;
        }
        p = p.next;
        return getRecursiveHelper(p, index - 1);
    }
}
