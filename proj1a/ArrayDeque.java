public class ArrayDeque<T> {
    private T[] items;
    private int size;

    private int nextFirst;
    private int nextLast;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] =  item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        int index = plusOne(nextFirst);
        if (nextFirst + size < items.length) {
            System.arraycopy(items, index, newArray, 0, size);
        }
        else {
            System.arraycopy(items, index, newArray, 0,items.length - index);
            System.arraycopy(items, 0, newArray, items.length - index, size - items.length + index);
        }
        items = newArray;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] =  item;
        size += 1;
        nextLast = plusOne(nextLast);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        int index = plusOne(nextFirst);
        for (int i = 0;  i < size; i += 1) {
            System.out.print(items[index] + " ");
            index = plusOne(index);
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (items.length >= 16) {
            shrink();
        }
        int index = plusOne(nextFirst);
        T first = items[index];
        items[index] = null;
        size -= 1;
        nextFirst = index;
        return first;
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (items.length >= 16) {
            shrink();
        }
        int index = minusOne(nextLast);
        T last = items[index];
        items[index] = null;
        size -= 1;
        nextLast = index;
        return last;
    }

    private void shrink() {
        if ((size - 1) / (double) items.length < 0.25) {
            resize((size - 1) * 2);
        }
    }
    public T get(int index) {
        if (index < 0 || index >= size || isEmpty()) {
            return null;
        }
        index = (index + nextFirst + 1) % items.length;
        return items[index];
    }
}
