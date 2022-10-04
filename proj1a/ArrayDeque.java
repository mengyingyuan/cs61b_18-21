public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public int size(){
        return size;
    }

    public void addFirst(T item){
        if(size == items.length){
            resize(size * 2);
        }
        items[nextFirst] =  item;
        size +=1;
        nextFirst = minusOne(nextFirst);
    }

    public void resize(int capacity){
        T[] newArray = (T[]) new Object[capacity];
        int index = plusOne(nextFirst);
        System.arraycopy(items, index, newArray, 0, size-index);
        if(index!= 0){
            System.arraycopy(items, 0, newArray,size-index, index);
        }
        items = newArray;
        nextFirst = capacity-1;
        nextLast = size;
    }

    public void addLast(T item){
        if(size == items.length){
            resize(size * 2);
        }
        items[nextLast] =  item;
        size +=1;
        nextLast = plusOne(nextLast);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printDeque(){
        int index = plusOne(nextFirst);
        for(int i = 0 ;  i <size; i+=1 ){
            System.out.print(items[index] + " ");
            index = plusOne(index);
        }
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        int index = plusOne(nextFirst);
        T first = items[index];
        items[index] = null;
        size -= 1;
        nextFirst = index;
        return first;
    }

    public int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    public int plusOne(int index) {
        int idx =  (index + 1) % items.length;
        return idx;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        int index = minusOne(nextLast);
        T last = items[index];
        items[index] = null;
        size -= 1;
        nextLast = index;
        return last;
    }

    public T get(int index){
        if(index<0 || index >= size || isEmpty()) {
            return null;
        }
        index = (index + nextFirst +1) % items.length;
        return items[index];
    }
}
