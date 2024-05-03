package deque;

import java.lang.reflect.Type;
import java.util.Iterator;

/* my invariants
* I'm using a circular approach for my ArrayDeque
* nextLast and nextFirst are chosen arbitrarily
* nextLast increases after every addFirst(); operation till it reaches the last element index which is 7 in our case
* nextFirst decreases after every addFirst operation
* resizing when size EQUALS the length of the underlying array
*
 * */
public class ArrayDeque<Item> implements Deque<Item>, Iterable<Item> {
    private static final int START_SIZE = 8;
    private Item[] items;
    private int size;
//    private final int ratio = size / items.length;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque(){
        items = (Item[]) new Object[START_SIZE];
        size = 0;
        nextFirst = 3;
        nextLast= 4;
    }


    public int size(){
        return size;
    }
    private void resizeUp(int capacity){
        Item[] array = (Item[]) new Object[capacity];
        int length = items.length;
        for(int i = 0; i < length; i++){
            array[i] = get(i);
        }
        items = array;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    private void resizeDown(int capacity){
        Item[] array = (Item []) new Object[capacity];
        for(int i = 0; i < capacity; i++){
            array[i] = get(i);
        }
        items = array;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(Item element){
        //resize should be done here before anything in case of the underlying array is full of items
        if(size() == items.length){
            resizeUp(size * 2);
        }

        if(nextFirst < 0){
            nextFirst = items.length - 1;
        }

        items[nextFirst] = element;
        size = size + 1;
        nextFirst = nextFirst - 1;
    }


    public Item getFirst(){
        int index = prevIndex(nextFirst);
        return items[index];
    }


    /** a helper method to return index of the first element */
    private int getFirstIndex(){
        int index = prevIndex(nextFirst);
        return index;
    }

    /** a helper method to return the index of previous element of the first element */
    private int prevIndex(int index){
        int prevIndex;
        if(index == items.length - 1) {
            prevIndex = 0;
            return prevIndex;
        }
        prevIndex = nextFirst + 1;
        return prevIndex;
    }

    public Item removeFirst(){

        if(getFirst() == null){
            return null;
        }

        if( size >= 16 && size < items.length / 4 ){
            resizeDown( size / 2);
        }

        int index = getFirstIndex();
        Item value = getFirst();
        items[index] = null;
        size = size - 1;
        nextFirst = index;
        return value;
    }

    public void addLast(Item element){
        //resize should be done here before anything in case of the underlying array is full of items
        if(size() == items.length){
            resizeUp(size * 2);
        }

        if(nextLast == items.length){
            nextLast = 0;
        }

        items[nextLast] = element;
        size = size + 1;
        nextLast = nextLast + 1;
    }

    public Item getLast(){
        return items[nextLast - 1];
    }


    public Item removeLast(){
        Item value = getLast();
        if(value == null){
            return null;
        }

        if(items.length >= 16 &&  size < items.length / 4 ){
            resizeDown(items.length / 2);
        }

        if(nextLast == 0){
            nextLast = items.length;
        }
        items[nextLast - 1] = null;
        size = size - 1;
        nextLast = nextLast - 1;
        return value;
    }



    public Item get(int index){
        int i = getFirstIndex();
        int length = items.length;
        return items[(i + index) % length];
    }


    public void printDeque(){
        int size = size();
        int i = 0;
        while(i < size){
            System.out.println(get(i));
            i++;
        }
    }

    public Iterator<Item> iterator(){
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<Item>{
        private int index;

        public ArrayDequeIterator(){
            index = 0;
        }

        @Override
        public boolean hasNext(){
            return index < size;
        }

        @Override
        public Item next(){
            Item item = get(index);
            index++;
            return item;
        }
    }

    @Override
    public boolean equals(Object o){
        int index = 0;
        if(this == o){
            return true;
        }

        if(o instanceof ArrayDeque){
            ArrayDeque deque = (ArrayDeque) o;
            if(this.size != deque.size){
                return false;
            }

            for(Item x : this){
                Item y = (Item) deque.get(index);
                if(y != x){
                    return false;
                }
                index += 1;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}